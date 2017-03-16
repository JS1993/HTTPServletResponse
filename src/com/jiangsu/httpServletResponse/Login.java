package com.jiangsu.httpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class Login extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		ValidateCode code = new ValidateCode(110, 25, 4, 9);
		
		//向session中保存验证码
		String codex = code.getCode();
		request.getSession().setAttribute("scode", codex);
		code.write(response.getOutputStream());
	
	}

	public void createCode(HttpServletResponse response) throws IOException {
		BufferedImage img = new BufferedImage(110, 25, BufferedImage.TYPE_INT_RGB);
		Graphics gra = img.getGraphics();
		
		//设置填充颜色
		gra.setColor(Color.pink);
		gra.fillRect(1, 1, 110-2, 25-2);
		
		//设置边框样式
		gra.setColor(Color.RED);
		gra.drawRect(0, 0, 110-1, 25-1);
		
		//设置文本样式
		gra.setColor(Color.BLUE);
		gra.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		
		//添加文本
		Random rand = new Random();
		int position = 20;
		for(int i = 0; i<4; i++){
			gra.drawString(rand.nextInt(10)+"", position, 20);
			position+=20;
		}
		
		//添加9条干扰线
		for(int i=0;i<9;i++ ){
			gra.drawLine(rand.nextInt(110),rand.nextInt(25),rand.nextInt(110),rand.nextInt(25));
		}
		
		//将图片对象以流的方式输出到客户端
		ImageIO.write(img, "jpg", response.getOutputStream());
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
