package com.stackDigest.stackDigest.entity.QuestionsAll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
	private String reputation;
	private String user_id;
	private String user_type;
	private String profile_image;
	private String display_name;
	private String link;

	public Owner() {}
	public Owner(String reputation, String user_id, String user_type, String profile_image, String display_name, String link) {
		this.reputation = reputation;
		this.user_id = user_id;
		this.user_type = user_type;
		this.profile_image = profile_image;
		this.display_name = display_name;
		this.link = link;
	}

	public String getReputation() {
		return reputation;
	}

	public void setReputation(String reputation) {
		this.reputation = reputation;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Owner{" +
				"reputation='" + reputation + '\'' +
				", user_id='" + user_id + '\'' +
				", user_type='" + user_type + '\'' +
				", profile_image='" + profile_image + '\'' +
				", display_name='" + display_name + '\'' +
				", link='" + link + '\'' +
				'}';
	}
}
