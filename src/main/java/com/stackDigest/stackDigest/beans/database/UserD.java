package com.stackDigest.stackDigest.beans.database;

import javax.persistence.*;
import java.util.List;

@Entity(name = "userd")
public class UserD implements Cloneable{
	@Id
	@Column(nullable = false, columnDefinition="VARCHAR(64)")
	String id;
	@Column
	String password;
	@Column(unique = true)   //made unique so that a user does not register twice
	int stackid;
	@Column
	String accesstoken;
	@Column
	String role;
	@Column
	String tag1;
	@Column
	String tag2;
	@Column
	String tag3;
	@Column
	String tag4;
	@Column
	String tag5;
	@Column
	String displayname;
	@Column
	String profileimage;
	@Column
	String userlink;
//	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "id",referencedColumnName = "id")
	List<UserD_seen> seen;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStackid() {
		return stackid;
	}

	public void setStackid(int stackid) {
		this.stackid = stackid;
	}

	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public String getTag4() {
		return tag4;
	}

	public void setTag4(String tag4) {
		this.tag4 = tag4;
	}

	public String getTag5() {
		return tag5;
	}

	public void setTag5(String tag5) {
		this.tag5 = tag5;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getProfileimage() {
		return profileimage;
	}

	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}

	public String getUserlink() {
		return userlink;
	}

	public void setUserlink(String userlink) {
		this.userlink = userlink;
	}

	@Override
	public String toString() {
		return "UserD{" +
				"id='" + id + '\'' +
				", password='" + password + '\'' +
				", stackid=" + stackid +
				", accesstoken='" + accesstoken + '\'' +
				", role='" + role + '\'' +
				", tag1='" + tag1 + '\'' +
				", tag2='" + tag2 + '\'' +
				", tag3='" + tag3 + '\'' +
				", tag4='" + tag4 + '\'' +
				", tag5='" + tag5 + '\'' +
				", displayname='" + displayname + '\'' +
				", profileimage='" + profileimage + '\'' +
				", userlink='" + userlink + '\'' +
				", seen=" + seen +
				'}';
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
