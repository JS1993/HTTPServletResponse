package com.jiangsu.httpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadTest extends HttpServlet {


	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path= this.getServletContext().getRealPath("/WEB-INF/classes/0.JPG");
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = response.getOutputStream();
		//得到文件名
//		String filename = path.substring(path.lastIndexOf("\\")+1);
//		//s设置文件名的编码
//		filename= URLEncoder.encode(filename,"UTF-8");
//		
//		response.setHeader("content-disposition", "attachment;filename="+filename);
//		response.setHeader("content-type", "image/jpeg");
		int len =1;
		byte[] b = new byte[1024];
		while((len=fis.read(b))!=-1){
			sos.write(b,0,len);
		}
		sos.close();
		fis.close();
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}


}
