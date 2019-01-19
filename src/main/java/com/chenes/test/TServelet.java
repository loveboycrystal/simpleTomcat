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

import com.chenes.simpletomcat.entity.ChenesRequest;
import com.chenes.simpletomcat.entity.ChenesResponse;
import com.chenes.simpletomcat.inteface.BaseServlet;

public class TServelet extends BaseServlet {

	public void doGet(ChenesRequest myRequest, ChenesResponse myResponse) {
		try {
			myResponse.write("hello dsx.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(ChenesRequest myRequest, ChenesResponse myResponse) {
		try {
			myResponse.write("doPost dsx.");
			System.out.println(myRequest.getParameterByName("name"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
