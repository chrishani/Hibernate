package com.im.hibernate.demo;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.im.hibernate.model.Member;

public class Demo {

	public static void main(String[] args) {
		Member member =  new Member();
		//Set Values
		//member.setId(1);
		member.setName("Nadun Liyanage");
		member.setAddress("19D, Pagoda Roda, Nugegoda.");
		member.setTelephone("0117222181");
		member.setJoinDate(new Date());
		member.setBirthDay(new Date());

		Configuration config = new Configuration();
		SessionFactory sf = config.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		//session.save(member);
		//session.getTransaction().commit();
		
		Member m1 = (Member)session.get(Member.class,1);
		System.out.println("Name = "+m1.getName());
		
		List<Member> list = session.createCriteria(Member.class).list();
		
		for(Member mem :list){
			System.out.println("M = "+mem.getName());
		}
		
		Member kamal = (Member)session.get(Member.class, 2);
		kamal.setName("Kamal Hasan");
		kamal.setAddress("Galle Road, Wellawatte.");
		kamal.setTelephone("0112333222");
		kamal.setJoinDate(new Date());
		kamal.setBirthDay(new Date());
		
		session.update(kamal);
		session.getTransaction().commit();

		Member nadun = (Member) session.get(Member.class, 1);
		session.beginTransaction();
		session.delete(nadun);
		session.getTransaction().commit();
		

		
		
	}
}
