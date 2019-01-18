/**
 * FileName: HelloWorldServelet
 * Author:   Chenes
 * Date:     2019/1/17 22:02
 * Description: 业务测试的servlet
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 22:02   V.2.8.0             新建
 */
package com.chenes.test;

import java.io.IOException;

import myTomcat.MyRequest;
import myTomcat.MyResponse;
import myTomcat.MyServlet;

public class TServelet extends  MyServlet {

	public void doGet(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("hello dsx.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("doPost dsx.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
