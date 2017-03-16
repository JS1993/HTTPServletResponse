package com.jiangsu.httpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SkipPage extends HttpServlet {

	
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ȡ������
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		
		Cookie ck = new Cookie("userName", userName);
		ck.setPath("/");
	
		//����ҵ���߼�
		//ȡ��֤��
		String scode = (String)request.getSession().getAttribute("scode");
		//�ַ�ת��
		if("hongjiaqun".equals(userName)&&"1314520".equals(pwd)&&code.equalsIgnoreCase(scode)){
			response.getWriter().write("��½�ɹ���3���Ӻ���ת����ҳ");
			response.setHeader("refresh", "3;url=/homePage.html");
		}else{
			
			if(!code.equalsIgnoreCase(scode)){
				request.setAttribute("msg", "��֤�����");
				//ת������
				request.getRequestDispatcher("/index.jsp").forward(request, response);				
			}else{
				out.write("�û������������2��󷵻�");
				//����2���������µ�¼
				response.setHeader("refresh", "2;url="+request.getContextPath()+"/login.html");
			}
		}
		
		
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
