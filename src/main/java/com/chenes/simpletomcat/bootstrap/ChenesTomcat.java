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

import com.chenes.simpletomcat.entity.ChenesRequest;
import com.chenes.simpletomcat.entity.ChenesResponse;
import com.chenes.simpletomcat.inteface.BaseServlet;
import com.chenes.simpletomcat.mapping.ServletMapping;
import com.chenes.simpletomcat.mapping.ServletMappingContainer;

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

				ChenesRequest ChenesRequest = new ChenesRequest(inputStream);
				ChenesResponse ChenesResponse = new ChenesResponse(outputStream);

				dispatch(ChenesRequest,ChenesResponse);

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

	public void dispatch(ChenesRequest chenesRequest,ChenesResponse chenesResponse) {

		if( null == chenesRequest.getUrl() || null == chenesRequest.getMethod()){
			return;
		}

		String clazz = urlServletMap.get(chenesRequest.getUrl());

		if( null == clazz){
			return;
		}
		try {
			Class<BaseServlet> businessServletClass = (Class<BaseServlet>) Class.forName(clazz);

			BaseServlet businessServlet = businessServletClass.newInstance();
			System.out.println("do request:"+chenesRequest.getUrl());
			businessServlet.service(chenesRequest,chenesResponse);

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
