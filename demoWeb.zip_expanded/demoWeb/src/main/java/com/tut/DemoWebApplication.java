package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
		
//		System.out.println("Hello");
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
//		factory.openSession();
//		System.out.println(factory);
		Student st=new Student();
		st.setId(1);
		st.setName("Abhay");
		st.setCity("Indore");
		System.out.println(st);
		
		Session session=factory.openSession();
		
		session.beginTransaction();
		
		session.persist(st);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
