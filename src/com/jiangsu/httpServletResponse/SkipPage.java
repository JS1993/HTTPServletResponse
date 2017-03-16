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
		//获取表单数据
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		
		Cookie ck = new Cookie("userName", userName);
		ck.setPath("/");
	
		//处理业务逻辑
		//取验证码
		String scode = (String)request.getSession().getAttribute("scode");
		//分发转向
		if("hongjiaqun".equals(userName)&&"1314520".equals(pwd)&&code.equalsIgnoreCase(scode)){
			response.getWriter().write("登陆成功，3秒钟后跳转到主页");
			response.setHeader("refresh", "3;url=/homePage.html");
		}else{
			
			if(!code.equalsIgnoreCase(scode)){
				request.setAttribute("msg", "验证码错误");
				//转发请求
				request.getRequestDispatcher("/index.jsp").forward(request, response);				
			}else{
				out.write("用户名或密码错误！2秒后返回");
				//设置2秒跳到重新登录
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
