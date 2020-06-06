package com.stackDigest.stackDigest.MVC;

import com.stackDigest.stackDigest.StackDigestApplication;
import com.stackDigest.stackDigest.beans.database.ItemsD;
import com.stackDigest.stackDigest.beans.database.UserD;
import com.stackDigest.stackDigest.beans.database.UserD_seen;
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
    @RequestMapping("/feedData")
    @ResponseBody
    public ResponseEntity<List<ItemsD>> feed(HttpSession httpSession) {
        System.out.println("loggedIN check "+httpSession.getAttribute("currentUser"));
        Transaction transaction=null;
        try {
            UserD currentUser=(UserD)httpSession.getAttribute("currentUser");
            Session session = StackDigestApplication.getFactory().getCurrentSession();
            transaction = session.beginTransaction();
            List<ItemsD> itemsDList=null;
            System.out.println("init");
//            Query<Integer> test=session.createQuery("select :seen from ItemsD");
//            System.out.println("test "+test.list());

            Query<ItemsD> itemsDQuery = session.createQuery("from ItemsD as items where" +
                    " ('"+currentUser.getTag1()+"' in (elements(items.tags) ) or '"+currentUser.getTag2()+"' in (elements(items.tags) ) or '"+currentUser.getTag3()+"' in elements(items.tags) or '"+currentUser.getTag4()+"' in elements(items.tags) or '"+currentUser.getTag5()+"' in elements(items.tags) ) " +
                    "and items.id not in (select seen from UserD_seen where id='"+currentUser.getId()+"') ")
                    .setMaxResults(10);
            itemsDList = itemsDQuery.list();
            transaction.commit();

//            System.out.println(itemsDQuery.list());
            Transaction transaction1=null;
            try {
                Session session1=StackDigestApplication.getFactory().getCurrentSession();
                transaction1 = session1.beginTransaction();
                itemsDList.forEach((i) -> {
                    UserD_seen tmp = new UserD_seen(currentUser.getId(), i.getAssetId());
                    session1.save(tmp);
                });

                transaction1.commit();
            }
            catch (Exception e) {
                if (transaction1!=null)
                transaction1.rollback();
                e.printStackTrace();
            }
            System.out.println("query "+itemsDList);
            return new ResponseEntity<>(itemsDList, HttpStatus.OK);
        }
        catch (Exception e) {
//            if(transaction.)
//                transaction.rollback();
            e.printStackTrace();
            return null;
        }
        finally {
//            transaction.commit();
        }
    }
}
