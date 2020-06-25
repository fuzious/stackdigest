package com.stackDigest.stackDigest;

import com.stackDigest.stackDigest.beans.database.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
@EnableScheduling
public class StackDigestApplication {

	private static SessionFactory factory;
	private int i=1;
	public static SessionFactory getFactory() {
		return factory;
	}

	@PostConstruct
	public void startUp() {

		factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ItemsD.class)
				.addAnnotatedClass(OwnerD.class)
				.addAnnotatedClass(AnswersD.class)
				.addAnnotatedClass(UserD.class)
				.addAnnotatedClass(UserD_seen.class)
				.buildSessionFactory();
	}


	public static void main(String[] args) {
		SpringApplication.run(StackDigestApplication.class, args);
	}

	@PreDestroy
	public void shutdown() {
		System.out.println("Shut down");
		factory.close();
	}

}
