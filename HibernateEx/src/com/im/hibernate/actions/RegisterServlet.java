package com.im.hibernate.actions;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.im.hibernate.model.Member;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address  = request.getParameter("address");
		String tp = request.getParameter("tp");
		
		Member member =  new Member();
		member.setName(name);
		member.setAddress(address);
		member.setTelephone(tp);
		member.setJoinDate(new Date());
		member.setBirthDay(new Date());

		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();
	}

}
