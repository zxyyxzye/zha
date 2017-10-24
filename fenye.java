package com.hc.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hc.bean.PageBean;
import com.hc.bean.Student;
import com.hc.dao.Dao;
@WebServlet(value="/fy")
public class fenye extends HttpServlet{
	
	private Dao dao=new Dao();
	int x=1;
	int totalpage;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> findall=dao.select();
	
	try {
		x=Integer.parseInt(req.getParameter("x").trim());
		if(x<1){
			x=1;
		}else if(x>totalpage){
			x=totalpage;
		}
		
	} catch (Exception e) {
	}	
		totalpage =findall.size()/10;	
	int p=findall.size()%10;
	if(p!=0){
		totalpage=totalpage+1;
	}
	
	List<Student> findbypage=dao.findByPage((x-1)*10);
	HttpSession session = req.getSession();
	session.setAttribute("x", x);
	session.setAttribute("findbypage", findbypage);
	session.setAttribute("totalpage", totalpage);
	resp.sendRedirect("option.jsp");
	}

	
	private static final long serialVersionUID = 1L;

}
