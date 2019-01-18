/**
 * FileName: MyResponse
 * Author:   Chenes
 * Date:     2019/1/17 21:49
 * Description: 封装响应对象
 * History:
 * <author>          <time>          <version>          <desc>
 * chenes           2019/1/17 21:49   V.2.8.0             新建
 */
package myTomcat;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
	private OutputStream outputStream;

	public MyResponse(OutputStream outputStream){
		this.outputStream = outputStream;
	}

	public void write(String content) throws IOException {
		StringBuffer httpResponse = new StringBuffer();
		httpResponse.append("HTTP/1.1 200 OK\n")
				.append("Content-Type:text/html\n")
				.append("\r\n")
				.append("<html><body>")
				.append(content)
				.append("</body></html>");
		outputStream.write(httpResponse.toString().getBytes());
		outputStream.close();
	}
}
