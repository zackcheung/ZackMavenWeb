package com.zack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class DBRecordSearch extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String input1 = req.getParameter("keyword");

		if (input1 != null) {
			
			List<Staff> staffs = DBOperator.searchRecord(input1);
			PrintWriter out = resp.getWriter();
			out.println("Result:" + staffs.size()+"<br>");
			for(Staff staff: staffs){
				out.println(staff.getId()+" "+staff.getName()+" "+staff.getPhone()+" "+staff.getAddress()+"<br>");
			}
			/*
			for(int i =0; i < staffs.size(); i++){
				Staff staff = staffs.get(i);
				out.println(staff.getId()+" "+staff.getName()+" "+staff.getPhone()+" "+staff.getAddress()+"<br>");
			}
			*/
			out.close();
			
		} else {
			PrintWriter out = resp.getWriter();
			out.println("Error");
			out.close();
		}
	}
}