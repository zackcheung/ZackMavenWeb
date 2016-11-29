package com.zack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class DBRecordAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("Name");
		String phone = req.getParameter("Phone");
		String address = req.getParameter("Address");

		if (name != null) {
			DBOperator.addRecord(name, phone, address);
			resp.sendRedirect("index.html");
		} else {
			PrintWriter out = resp.getWriter();
			out.println("Error");
			out.close();
		}
	}
}