package com.stackDigest.stackDigest.webservice;

import com.stackDigest.stackDigest.beans.restfetch.QuestionsAll.JsonRootBean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/stackDigest")
public class QuestionAll {

	@GetMapping("/fetch")
	public static JsonRootBean fetch() {
		try {
//            usrPost = mapper.readValue(new URL("https://api.stackexchange.com//2.2/questions?order=desc&sort=activity&site=stackoverflow"), Question.class);
//			RestTemplate restTemplate=new RestTemplate();
//			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//			usrPost = restTemplate.getForObject("https://api.stackexchange.com//2.2/questions?order=desc&sort=activity&site=stackoverflow",Question.class);
//			System.out.println(usrPost);
//			return usrPost;

			final String uri = "https://api.stackexchange.com/2.2/search/advanced?page=1&order=desc&sort=votes&accepted=True&site=stackoverflow&filter=!)EhxQMOPc)dH94o7-NBjAb4AcHxu2_8*7Nua1q2CUHEgIfc*9";

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			JsonRootBean result = restTemplate.getForObject(uri, JsonRootBean.class);

			System.out.println(result);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
// https://api.stackexchange.com/2.2/search/advanced?page=1&order=desc&sort=votes&accepted=True&site=stackoverflow&filter=!)EhxQMOPc)dH94o7-NBjAb4AcHxu2_8*7Nua1q2CUHEgIfc*9
