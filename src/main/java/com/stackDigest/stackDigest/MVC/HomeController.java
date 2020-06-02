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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

	private static int workload=10;
	private static String salt=BCrypt.gensalt(workload);
	@RequestMapping("/")
	public String home(Model theModel) {
		System.out.println("hi");
		UserD newUser=new UserD();
		theModel.addAttribute("newuser",newUser);
		return "login";
	}

	@RequestMapping("/currentUser")
	@ResponseBody
	public UserD currentLoggedIn() {
		MyUserDetails fetchCurrentUser=(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return fetchCurrentUser.getUserD();
	}

	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "logout";
	}

	@RequestMapping("/loggedin")
	public String loggedin(HttpSession httpSession) throws CloneNotSupportedException {
		MyUserDetails fetchCurrentUser=(MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserD currentLoggedIn = fetchCurrentUser.getUserD();
//		System.out.println(currentLoggedIn);
		httpSession.setAttribute("currentUser",currentLoggedIn.clone());
//				theModel.addAttribute("currentUser",currentUser);
		return "feed";
	}

	@RequestMapping("/feed")
	public String feed() {
		return "feed";
	}

	@RequestMapping("/registerUser"	)
	public String registerUser(@ModelAttribute("newUser")UserD newUser,@ModelAttribute("access_token") String accesstoken) {

		final String userUri="https://api.stackexchange.com/2.2/me?order=desc&sort=reputation&site=stackoverflow&filter=!)69Ph.xUM9L(Fi(0_(vez0TM-xZ1&key=65fR1xeD5oDJ8rNnDW7YtA((&access_token="+newUser.getAccesstoken();
		System.out.println(newUser+" "+accesstoken+" "+userUri);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		JsonRootBeanUser userResult=restTemplate.getForObject(userUri,JsonRootBeanUser.class);
		newUser.setRole("user");
		newUser.setPassword(BCrypt.hashpw(newUser.getPassword(),salt));

		final String uri = "https://api.stackexchange.com/2.2/users/"+userResult.getItems().get(0).getUserId()+"/tags?order=desc&sort=popular&site=stackoverflow&filter=!-.G.68gzI8DP#";
		JsonRootBeanTag result = restTemplate.getForObject(uri,JsonRootBeanTag.class);
		System.out.println(userResult);
		assert result != null;
		assert userResult!=null;

		newUser.setTag1(result.getItems().get(0).getName());
		newUser.setTag2(result.getItems().get(1).getName());
		newUser.setTag3(result.getItems().get(2).getName());
		newUser.setTag4(result.getItems().get(3).getName());
		newUser.setTag5(result.getItems().get(4).getName());

		newUser.setStackid(	userResult.getItems().get(0).getUserId());
		newUser.setDisplayname(userResult.getItems().get(0).getDisplayName());
		newUser.setProfileimage(userResult.getItems().get(0).getProfileImage());
		newUser.setUserlink(userResult.getItems().get(0).getLink());

		System.out.println(newUser);

		Session session= StackDigestApplication.getSession();
		Transaction tx=session.beginTransaction();
		session.save(newUser);
		tx.commit();

		return "post";
	}
}
// fetch tags:
// https://api.stackexchange.com/2.2/users/6118183/tags?order=desc&sort=popular&site=stackoverflow&filter=!-.G.68gzI8DP#
