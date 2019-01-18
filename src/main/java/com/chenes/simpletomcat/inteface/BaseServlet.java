/**
 * FileName: MyServlet
 * Author:   Chenes
 * Date:     2019/1/17 21:57
 * Description: Tomcat提供API get and post
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 21:57   V.2.8.0             新建
 */
package com.chenes.simpletomcat.inteface;

import myTomcat.MyRequest;
import myTomcat.MyResponse;

public abstract class BaseServlet {
	public abstract void doGet(MyRequest myRequest,MyResponse myResponse);
	public abstract void doPost(MyRequest myRequest,MyResponse myResponse);

	public void service(MyRequest myRequest,MyResponse myResponse){
		if(myRequest.getMethod().equalsIgnoreCase("POST")){
			doGet(myRequest,myResponse);
		}else if(myRequest.getMethod().equalsIgnoreCase("GET")){
			doPost(myRequest,myResponse);
		}
	}
}
