/**
 * FileName: MyTomcat
 * Author:   Chenes
 * Date:     2019/1/17 22:14
 * Description: 启动服务器入口
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 22:14   V.2.8.0             新建
 */
package com.chenes.simpletomcat.bootstrap;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import myTomcat.*;

public class ChenesTomcat {
	private int port = 80;

	ServerSocket serverSocket = null;

	private Map<String,String> urlServletMap = new HashMap<String, String>();

	public ChenesTomcat(int port) {
		this.port = port;
	}

	public void start(){
		initServletMapping();
		try {
			serverSocket = new ServerSocket(port);

			System.out.println("MyTomcat is start.....");

			while(true){
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();

				MyRequest myRequest = new MyRequest(inputStream);
				MyResponse myResponse = new MyResponse(outputStream);

				dispatch(myRequest,myResponse);

				socket.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if( null != serverSocket){
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void initServletMapping(){
		for(ServletMapping servletMapping : ServletMappingContainer.servletMappingList){
			urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
		}
	}

	public void dispatch(MyRequest myRequest,MyResponse myResponse) {

		if( null == myRequest.getUrl() || null == myRequest.getMethod()){
			return;
		}

		String clazz = urlServletMap.get(myRequest.getUrl());

		if( null == clazz){
			return;
		}
		try {
			Class<MyServlet> businessServletClass = (Class<MyServlet>) Class.forName(clazz);

			MyServlet businessServlet = businessServletClass.newInstance();
			System.out.println("do request:"+myRequest.getUrl());
			businessServlet.service(myRequest,myResponse);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChenesTomcat(80).start();
	}

}
