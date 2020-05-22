package com.stackDigest.stackDigest.MVC;

import com.stackDigest.stackDigest.StackDigestApplication;
import com.stackDigest.stackDigest.beans.database.ItemsD;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FeedController {
    @RequestMapping("/feed")
    public String feed(Model theModel) {

        Session session= StackDigestApplication.getFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<ItemsD> itemsDList;
        Query<ItemsD> itemsDQuery=session.createQuery("from ItemsD").setFirstResult(2).setMaxResults(2);
        itemsDList=itemsDQuery.list();
        theModel.addAttribute("questions",itemsDList);
        return "feed";
    }
}
