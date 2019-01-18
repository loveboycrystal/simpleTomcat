/**
 * FileName: HelloWorldServelet
 * Author:   Chenes
 * Date:     2019/1/17 22:02
 * Description: 业务测试的servlet
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 22:02   V.2.8.0             新建
 */
package myTomcat;

import java.io.IOException;

public class HelloWorldServelet extends  MyServlet {

	public void doGet(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("doget hello.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("doPost hello.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
