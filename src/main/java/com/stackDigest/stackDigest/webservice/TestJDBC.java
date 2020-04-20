package com.stackDigest.stackDigest.webservice;

import com.stackDigest.stackDigest.beans.database.Answer;
import com.stackDigest.stackDigest.beans.database.Items;
import com.stackDigest.stackDigest.beans.database.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class TestJDBC {
    public static void main(String[] args) {
//        String jdbcUrl="jdbc:mysql://localhost:3306/stackdigest";
//        String user="root";
//        String pass="arpit";
//        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection myConn= DriverManager.getConnection(jdbcUrl,user,pass);
//            System.out.println("SUCCESS");
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Items.class).addAnnotatedClass(Owner.class).addAnnotatedClass(Answer.class).buildSessionFactory();
        Session session=factory.openSession();

        try {
            System.out.println("Creating items");
            Items item=new Items();
            item.setLink("x");
            item.setAssetId(1);
            item.setDisplayName("a");
            item.setProfileImage("x");
            item.setBody("bdy");
            item.setLink("lin");
            item.setScore(100);
            item.setTitle("title");
            Set<String> x=new HashSet<>();
            x.add("tg");
            x.add("th");
            item.setTags(x);

            Answer answer=new Answer();
            answer.setBody("ab");
            answer.setScore(100);
            answer.setAssetId(200);
            item.setAnswer(answer);

            Transaction tx=session.beginTransaction();
            session.save(item);
            tx.commit();
            System.out.println("done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
