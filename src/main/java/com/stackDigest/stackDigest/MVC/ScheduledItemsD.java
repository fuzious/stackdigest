package com.stackDigest.stackDigest.MVC;

import com.stackDigest.stackDigest.StackDigestApplication;
import com.stackDigest.stackDigest.beans.database.AnswersD;
import com.stackDigest.stackDigest.beans.database.ItemsD;
import com.stackDigest.stackDigest.beans.restfetch.QuestionsAll.Answers;
import com.stackDigest.stackDigest.beans.restfetch.QuestionsAll.Items;
import com.stackDigest.stackDigest.beans.restfetch.QuestionsAll.JsonRootBean;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

public class ScheduledItemsD {

    int i=1;
    @Scheduled(fixedDelay = 5000)
    public void delay() {
        System.out.println("hi");
        Session session= StackDigestApplication.getFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();

        try {
            String uri = "https://api.stackexchange.com/2.2/search/advanced?page="+i+"&access_token=lcuewul2VbbADWgKoQAO2w))&key=65fR1xeD5oDJ8rNnDW7YtA((&order=desc&sort=votes&accepted=True&site=stackoverflow&filter=!)EhxQMOPc)dH94o7-NBjAb4AcHxu2_8*7Nua1q2CUHEgIfc*9";
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
