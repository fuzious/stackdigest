package com.stackDigest.stackDigest.webservice;

import com.stackDigest.stackDigest.entity.QuestionsAll.Question;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/stackDigest")
public class QuestionAll {

	@GetMapping("/fetch")
	public static Question fetch() {
		Question usrPost;
		try {
			//            usrPost = mapper.readValue(new URL("https://api.stackexchange.com//2.2/questions?order=desc&sort=activity&site=stackoverflow"), Question.class);
//			RestTemplate restTemplate=new RestTemplate();
//			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//			usrPost = restTemplate.getForObject("https://api.stackexchange.com//2.2/questions?order=desc&sort=activity&site=stackoverflow",Question.class);
//			System.out.println(usrPost);
//			return usrPost;

			final String uri = "https://api.stackexchange.com//2.2/questions?order=desc&sort=activity&site=stackoverflow";

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			Question result = restTemplate.getForObject(uri, Question.class);

			System.out.println(result);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
