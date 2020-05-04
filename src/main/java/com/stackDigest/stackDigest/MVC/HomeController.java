package com.stackDigest.stackDigest.MVC;

import com.stackDigest.stackDigest.StackDigestApplication;
import com.stackDigest.stackDigest.beans.database.UserD;
import com.stackDigest.stackDigest.beans.restfetch.tagfetch.JsonRootBeanTag;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model theModel) {
		System.out.println("hi");
		UserD newUser=new UserD();
		theModel.addAttribute("newuser",newUser);
		return "index";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}

	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "logout";
	}

	@RequestMapping("/registerUser")
	public String registerUser(@ModelAttribute("newuser")UserD newUser) {

		final String uri = "https://api.stackexchange.com/2.2/users/"+newUser.getId()+"/tags?order=desc&sort=popular&site=stackoverflow&filter=!-.G.68gzI8DP#";

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		JsonRootBeanTag result = restTemplate.getForObject(uri,JsonRootBeanTag.class);
		newUser.setRole("user");
		assert result != null;
		newUser.setTag1(result.getItems().get(0).getName());
		newUser.setTag2(result.getItems().get(1).getName());
		newUser.setTag3(result.getItems().get(2).getName());
		newUser.setTag4(result.getItems().get(3).getName());
		newUser.setTag5(result.getItems().get(4).getName());
	
		Session session= StackDigestApplication.getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.save(newUser);
		tx.commit();

		return "post";
	}
}
// fetch tags:
// https://api.stackexchange.com/2.2/users/6118183/tags?order=desc&sort=popular&site=stackoverflow&filter=!-.G.68gzI8DP#
