package com.stackDigest.stackDigest.MVC;

import com.stackDigest.stackDigest.StackDigestApplication;
import com.stackDigest.stackDigest.beans.database.ItemsD;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ViewController {
    @RequestMapping("/feed")
    @ResponseBody
    public ResponseEntity<List<ItemsD>> feed(HttpSession httpSession) {
        System.out.println("loggedIN check "+httpSession.getAttribute("currentUser"));
        Transaction transaction=null;
        try {
            Session session = StackDigestApplication.getSession();
            transaction = session.beginTransaction();
            List<ItemsD> itemsDList;
            Query<ItemsD> itemsDQuery = session.createQuery("from ItemsD").setFirstResult(3).setMaxResults(2);
            itemsDList = itemsDQuery.list();
            transaction.commit();
            System.out.println(itemsDList);
            return new ResponseEntity<>(itemsDList, HttpStatus.OK);

        }
        catch (Exception e) {
            transaction.rollback();
            return null;
        }
        finally {
//            transaction.commit();
        }
    }
}
