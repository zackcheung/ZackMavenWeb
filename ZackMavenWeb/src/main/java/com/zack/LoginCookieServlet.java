package com.zack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCookieServlet extends HttpServlet {

 private String AUTO_USER_KEY = "AUTO_USER_KEY";
 private String TEST_USER = "zack";
 private String TEST_PWD = "123456";

 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  Cookie[] cookies = request.getCookies();
  if (cookies != null) {
   for (Cookie cookie : cookies) {
    if (null != cookie.getName() && null != cookie.getValue()) {
     String name = cookie.getName();
     String value = cookie.getValue();
     if (AUTO_USER_KEY.equals(name) && (TEST_USER + "||"+TEST_PWD).equals(value)) {
      // ¦³¨ú±ouser
      request.setAttribute("user", value.toString().split("||")[0]);
      request.getRequestDispatcher("/user.view").forward(request, response);
      return;
     }
    }
   }
  }
  response.sendRedirect("login.html");
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  processRequest(request, response);
 }

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  processRequest(request, response);
 }
}