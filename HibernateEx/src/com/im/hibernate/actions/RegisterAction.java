package com.im.hibernate.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.im.hibernate.model.Member;
 
 

@WebServlet("/reg")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Collect Form Fields
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		
		//2. Create Model Bean
		Member member = new Member();
		member.setName(name);
		member.setAddress(address);
		member.setEmail(email);
		member.setPassword(password);
		member.setMobile(mobile);
		
		//3. Persist Object via Hibernate
		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();
		
		//4. Give a Message
		PrintWriter out = response.getWriter();
		out.print("<h1> Success</h1>");

	}

}
