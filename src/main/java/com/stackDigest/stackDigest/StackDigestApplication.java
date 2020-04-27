package com.stackDigest.stackDigest;

import com.stackDigest.stackDigest.beans.QuestionsAll.Answers;
import com.stackDigest.stackDigest.beans.QuestionsAll.Items;
import com.stackDigest.stackDigest.beans.QuestionsAll.JsonRootBean;
import com.stackDigest.stackDigest.beans.database.AnswersD;
import com.stackDigest.stackDigest.beans.database.ItemsD;
import com.stackDigest.stackDigest.beans.database.OwnerD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Calendar;

@SpringBootApplication
//@EnableScheduling
public class StackDigestApplication {

	private SessionFactory factory;
	int i=1;

	public SessionFactory getFactory() {
		return factory;
	}

	@PostConstruct
	public void startUp() {
		factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(ItemsD.class)
				.addAnnotatedClass(OwnerD.class)
				.addAnnotatedClass(AnswersD.class)
				.buildSessionFactory();
	}


	public static void main(String[] args) {
		
		SpringApplication.run(StackDigestApplication.class, args);
	}

//	@Scheduled(fixedDelay = 5000)
	public void delay() {

		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();

		try {
			String uri = "https://api.stackexchange.com/2.2/search/advanced?page="+i+"&order=desc&sort=votes&accepted=True&site=stackoverflow&filter=!)EhxQMOPc)dH94o7-NBjAb4AcHxu2_8*7Nua1q2CUHEgIfc*9";
			i++;
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			JsonRootBean result = restTemplate.getForObject(uri, JsonRootBean.class);
			assert result != null;
			for (Items x:result.getItems()) {
//				System.out.println(genItemsD(x));
				session.save(genItemsD(x));
			}

			tx.commit();
			System.out.println(Calendar.getInstance().getTime()+" done");

		}
		catch (Exception e) {
			if (tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	@PreDestroy
	public void shutdown() {
		factory.close();
	}

	public static ItemsD genItemsD(Items items) {
		ItemsD itemsD=new ItemsD();

		itemsD.setAssetId(items.getQuestionId());
		itemsD.setBody(items.getBody());
		itemsD.setLink(items.getLink());
		itemsD.setTitle(items.getTitle());
		itemsD.setTags(items.getTags());
		itemsD.setScore(items.getScore());
		itemsD.setOwnerLink(items.getOwner().getLink());
		itemsD.setProfileImage(items.getOwner().getProfileImage());
		itemsD.setDisplayName(items.getOwner().getDisplayName());

		AnswersD answersD = new AnswersD();
		answersD.setAssetId(items.getAcceptedAnswerId());

		for (Answers x: items.getAnswers()) {
			if (x.getIsAccepted()) {
				answersD.setBody(x.getBody());
				answersD.setCreationDate(x.getCreationDate());
				answersD.setScore(x.getScore());
				answersD.setDisplayName(x.getOwner().getDisplayName());
				answersD.setOwnerLink(x.getOwner().getLink());
				answersD.setProfileImage(x.getOwner().getProfileImage());
			}
		}

		itemsD.setAnswersD(answersD);

		return itemsD;
	}

}
