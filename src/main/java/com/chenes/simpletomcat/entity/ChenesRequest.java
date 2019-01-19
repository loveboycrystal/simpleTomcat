/**
 * FileName: MyRequest
 * Author:   Chenes
 * Date:     2019/1/17 21:41
 * Description: 封装请求对象
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 21:41   V.2.8.0             新建
 */
package com.chenes.simpletomcat.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ChenesRequest {
	private String  url;
	private String method;

	private HashMap<String,Object> param; //请求参数



	public ChenesRequest(InputStream inputStream) throws IOException {
		String httpRequest = "";
		byte[] httpRequestBytes = new byte[1024];
		int length = 0;
		if((length = inputStream.read(httpRequestBytes)) > 0 ){
			httpRequest = new String(httpRequestBytes,0,length);
		}
		if("".equals(httpRequest.trim())){
			return;
		}
		String httpHead = httpRequest.split("\n")[0];
		this.method = httpHead.split("\\s")[0];
		this.url = httpHead.split("\\s")[1].split("[?]")[0];
		setParamValue( httpHead.split("\\s")[1]);
	}

	public Object getParameterByName(String parameterName){
		return param.get(parameterName);
	}

	private void setParamValue(String url){
		param = new HashMap<String, Object>();
		if(url.length() == 0){
			return;
		}
		String[] strParam = url.split("[?]");

		if(strParam.length == 1){
			return;
		}

		String[] strParamArr = strParam[1].split("[&]");

		for(int i=0; i<strParamArr.length; i++){
			String[] paramItem = strParamArr[i].split("[=]");
			param.put(paramItem[0],paramItem[1]);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public static void main(String[] args) {
		String a = "aaa&123";
		System.out.println(a.split("[&]")[1]);
	}
}
