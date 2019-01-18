/**
 * FileName: MyRequest
 * Author:   Chenes
 * Date:     2019/1/17 21:41
 * Description: 封装请求对象
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 21:41   V.2.8.0             新建
 */
package myTomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
	private String  url;
	private String method;

	public MyRequest(InputStream inputStream) throws IOException {
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
		method = httpHead.split("\\s")[0];
		url = httpHead.split("\\s")[1];
		System.out.println(this);
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
}
