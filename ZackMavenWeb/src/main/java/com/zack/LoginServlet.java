package com.zack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	 private String AUTO_USER_KEY = "AUTO_USER_KEY";
	 private String TEST_USER = "zack";
	 private String TEST_PWD = "123456";

	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String user = req.getParameter("user");
	  String passwd = req.getParameter("password");
	  if (TEST_USER.equals(user) && TEST_PWD.equals(passwd)) {
	   String login = req.getParameter("login");
	   if ("auto".equals(login)) {
	    Cookie cookie = new Cookie(AUTO_USER_KEY, TEST_USER + "||" + TEST_PWD);
	    cookie.setMaxAge(7 * 24 * 60 * 60);
	    resp.addCookie(cookie);
	   }
	   req.setAttribute("user", user);
	   req.getRequestDispatcher("user.view").forward(req, resp);
	  } else {
	   resp.sendRedirect("login.html");
	  }
	 }
	}