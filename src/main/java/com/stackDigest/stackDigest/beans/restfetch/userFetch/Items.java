package com.stackDigest.stackDigest.beans.restfetch.userFetch;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {

    private int reputation;
    @JsonProperty("user_id")
    private int userId;
    private String link;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    public void setReputation(int reputation) {
         this.reputation = reputation;
     }
     public int getReputation() {
         return reputation;
     }

    public void setUserId(int userId) {
         this.userId = userId;
     }
     public int getUserId() {
         return userId;
     }

    public void setLink(String link) {
         this.link = link;
     }
     public String getLink() {
         return link;
     }

    public void setProfileImage(String profileImage) {
         this.profileImage = profileImage;
     }
     public String getProfileImage() {
         return profileImage;
     }

    public void setDisplayName(String displayName) {
         this.displayName = displayName;
     }
     public String getDisplayName() {
         return displayName;
     }

}
