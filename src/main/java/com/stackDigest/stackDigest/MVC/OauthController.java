package com.stackDigest.stackDigest.MVC;

import com.stackDigest.stackDigest.beans.database.UserD;
import com.stackDigest.stackDigest.beans.restfetch.JsonRootBeanAccessToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OauthController {
    public static String client_id="XXX";
    public static String client_secret="XXX";
    public static String key="XXX";
    public static String redirect_uri="https://stackdigest.herokuapp.com/oauth/final";

    @RequestMapping("/oauth/init")
    public ModelAndView initOauth() {
        return new ModelAndView("redirect:"+"https://stackoverflow.com/oauth?client_id="+client_id+"&scope=no_expiry&redirect_uri="+redirect_uri);
    }

    @RequestMapping("/oauth/final")
    public String middleOauth(@RequestParam String code, Model theModel) throws Exception {
        String url="https://stackoverflow.com/oauth/access_token/json";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> multiValueMap=new LinkedMultiValueMap<>();
        multiValueMap.add("client_id",client_id);
        multiValueMap.add("client_secret",client_secret);
        multiValueMap.add("code",code);
        multiValueMap.add("redirect_uri",redirect_uri);

        HttpEntity<MultiValueMap<String,String>> mapHttpEntity= new HttpEntity<>(multiValueMap,headers);
        ResponseEntity<JsonRootBeanAccessToken> response = restTemplate.postForEntity( url, mapHttpEntity , JsonRootBeanAccessToken.class );
        if(response.getBody().getExpires()!=0)
            throw new Exception("the token is not no_expiry");
        UserD userD=new UserD();
        userD.setAccesstoken(response.getBody().getAccessToken());
        theModel.addAttribute("newUser",userD);
        return "registration";
    }
}
//3(XfR4q(IsTzfaijWg6*qg)) code
//65fR1xeD5oDJ8rNnDW7YtA(( key
//hlDGSXe81YSatw0(2rimNg)) token
