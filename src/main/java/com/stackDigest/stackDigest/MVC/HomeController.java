package com.stackDigest.stackDigest.MVC;

import com.stackDigest.stackDigest.StackDigestApplication;
import com.stackDigest.stackDigest.beans.database.UserD;
import com.stackDigest.stackDigest.beans.restfetch.tagfetch.JsonRootBeanTag;
import com.stackDigest.stackDigest.beans.restfetch.userFetch.JsonRootBeanUser;
import com.stackDigest.stackDigest.security.MyUserDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	private static int workload=10;
	private static String salt=BCrypt.gensalt(workload);

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

	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "logout";
	}

	@RequestMapping("/loggedin")
	public String loggedin(Model theModel) {
		MyUserDetails fetchCurrentUser=(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserD currentUser=fetchCurrentUser.getUserD();
		theModel.addAttribute("currentUser",currentUser);
		return "loggedin";
	}

	@RequestMapping("/registerUser"	)
	public String registerUser(@ModelAttribute("newuser")UserD newUser) {

		final String uri = "https://api.stackexchange.com/2.2/users/"+newUser.getId()+"/tags?order=desc&sort=popular&site=stackoverflow&filter=!-.G.68gzI8DP#";
		final String userUri="https://api.stackexchange.com/2.2/users/"+newUser.getId()+"?order=desc&sort=reputation&site=stackoverflow&filter=!-B4.Y3b*SBQIU5-hiYEqW#";

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		JsonRootBeanTag result = restTemplate.getForObject(uri,JsonRootBeanTag.class);
		JsonRootBeanUser userResult=restTemplate.getForObject(userUri,JsonRootBeanUser.class);
		newUser.setRole("user");
		newUser.setPassword(BCrypt.hashpw(newUser.getPassword(),salt));


		assert result != null;
		assert userResult!=null;

		newUser.setTag1(result.getItems().get(0).getName());
		newUser.setTag2(result.getItems().get(1).getName());
		newUser.setTag3(result.getItems().get(2).getName());
		newUser.setTag4(result.getItems().get(3).getName());
		newUser.setTag5(result.getItems().get(4).getName());

		System.out.println(newUser);

		Session session= StackDigestApplication.getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		session.save(newUser);
		tx.commit();

		return "post";
	}
}
// fetch tags:
// https://api.stackexchange.com/2.2/users/6118183/tags?order=desc&sort=popular&site=stackoverflow&filter=!-.G.68gzI8DP#
