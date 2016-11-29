package com.zack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private String AUTO_USER_KEY = "AUTO_USER_KEY";
	private String TEST_USER = "zack";
	private String TEST_PWD = "123456";

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		if (req.getAttribute("user") == null) {
			resp.sendRedirect("login.view");
		} else {
			PrintWriter out = resp.getWriter();
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("");
			out.println("" + req.getAttribute("user") + "已登入");
			out.println("回首頁");
			out.println("");
			out.println("");
			out.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}