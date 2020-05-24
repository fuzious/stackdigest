package com.stackDigest.stackDigest.beans.restfetch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRootBeanAccessToken {

    @JsonProperty("access_token")
    private String accessToken;
    private int expires;
    public void setAccessToken(String accessToken) {
         this.accessToken = accessToken;
     }
     public String getAccessToken() {
         return accessToken;
     }

    public void setExpires(int expires) {
         this.expires = expires;
     }
     public int getExpires() {
         return expires;
     }

    @Override
    public String toString() {
        return "JsonRootBeanAccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expires=" + expires +
                '}';
    }
}
