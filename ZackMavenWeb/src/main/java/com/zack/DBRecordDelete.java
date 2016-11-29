package com.zack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DBRecordDelete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
			
			String input = req.getParameter("input");
			if(input == null){
				List<Staff> staffs = DBOperator.deleteRecord1();
				
				out.println("Result:" + staffs.size()+"<br>");
				
				out.print("<table border='1'>");;
				
				out.print("<tr>");
				out.print("<td>"+"Id"+"</td>");
				out.print("<td>"+"Name"+"</td>");
				out.print("<td>"+"Phone"+"</td>");
				out.print("<td>"+"Address"+"</td>");
				out.print("</tr>");
				
				for(Staff staff: staffs){
				out.print("<tr>");
				out.print("<td>"+staff.getId()+"</td>");
				out.print("<td>"+staff.getName()+"</td>");
				out.print("<td>"+staff.getPhone()+"</td>");
				out.print("<td>"+staff.getAddress()+"</td>");
				out.print("</tr>");
				}
				
				out.print("</table>");
				
				out.print("<form action=\"delete\" method=\"post\">");
				out.println("<br>"+"Please enter the ID to be deleted: "+"<input type=\"text\" name=\"input\" value=\""+ input +"\"><br>");
				out.println("<input type=\"submit\" value=\"Delete\">");
				out.print("</form>");
			}else{
				int id = Integer.parseInt(input);
				DBOperator.deleteRecord2(id);
				out.println("ID:"+id+" deleted!");
			}
			
			
			


			

			

			
			out.close();
			
			/*StaffTable staffTable = new StaffTable();
			
			for(Staff staff: staffs){
				staffTable.addRow(staff.getId(), staff.getName(), staff.getPhone(), staff.getAddress());
			}*/
			/*
			for(int i =0; i < staffs.size(); i++){
				Staff staff = staffs.get(i);
				out.println(staff.getId()+" "+staff.getName()+" "+staff.getPhone()+" "+staff.getAddress()+"<br>");
			}
			*/

		
	}
}