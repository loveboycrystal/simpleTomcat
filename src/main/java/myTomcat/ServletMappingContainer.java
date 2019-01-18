/**
 * Copyright (C), 2015-2019, 广州市闻乐信息科技有限公司
 * FileName: ServletMappingContainer
 * Author:   Chenes
 * Date:     2019/1/17 22:10
 * Description: todo
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 22:10   V.2.8.0             新建
 */
package myTomcat;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingContainer {
	public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();
	static{
		servletMappingList.add(new ServletMapping("helloWorldServlet","/hello","com.java.myTomcat.HelloWorldServelet"));
		servletMappingList.add(new ServletMapping("helloWorldServlet2","/dsx","com.java.myTomcat.TServelet"));
	}
}
