package com.ithc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//nothing
import com.ithc.dao.Insert;
@WebServlet(value="/add")
public class AddStudent extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Insert i = new Insert();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = new String(req.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
		String pwd = new String(req.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
		i.add(name, pwd);
		resp.sendRedirect("student");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
