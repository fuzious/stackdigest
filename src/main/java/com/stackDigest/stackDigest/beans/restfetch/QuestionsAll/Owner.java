package com.stackDigest.stackDigest.beans.restfetch.QuestionsAll;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Owner {

	@JsonProperty("profile_image")
	private String profileImage;
	@JsonProperty("display_name")
	private String displayName;
	private String link;
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

	public void setLink(String link) {
		this.link = link;
	}
	public String getLink() {
		return link;
	}

}
