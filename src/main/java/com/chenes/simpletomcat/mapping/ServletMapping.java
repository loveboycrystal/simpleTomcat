/**
 * Copyright (C), 2015-2019, 广州市闻乐信息科技有限公司
 * FileName: ServletMapping
 * Author:   Chenes
 * Date:     2019/1/17 22:04
 * Description: todo
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 22:04   V.2.8.0             新建
 */
package com.chenes.simpletomcat.mapping;

public class ServletMapping {
	private String servletName;

	private String url;

	private String clazz;

	public ServletMapping(String servletName, String url, String clazz) {
		this.servletName = servletName;
		this.url = url;
		this.clazz = clazz;
	}

	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
