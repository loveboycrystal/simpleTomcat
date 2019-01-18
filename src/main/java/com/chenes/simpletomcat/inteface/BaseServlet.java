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

import com.chenes.simpletomcat.entity.ChenesRequest;
import com.chenes.simpletomcat.entity.ChenesResponse;

public abstract class BaseServlet {
	public abstract void doGet(ChenesRequest chenesRequest, ChenesResponse chenesResponse);
	public abstract void doPost(ChenesRequest chenesRequest,ChenesResponse chenesResponse);

	public void service(ChenesRequest chenesRequest,ChenesResponse chenesResponse){
		if(chenesRequest.getMethod().equalsIgnoreCase("POST")){
			doGet(chenesRequest,chenesResponse);
		}else if(chenesRequest.getMethod().equalsIgnoreCase("GET")){
			doPost(chenesRequest,chenesResponse);
		}
	}
}
