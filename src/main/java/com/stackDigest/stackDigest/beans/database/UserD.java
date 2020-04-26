package com.stackDigest.stackDigest.beans.database;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class UserD {
	@Id
	int id;
	@Column
	String password;
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
	@ElementCollection
	List<Integer> seen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Integer> getSeen() {
		return seen;
	}

	public void setSeen(List<Integer> seen) {
		this.seen = seen;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", password='" + password + '\'' +
				", tag1='" + tag1 + '\'' +
				", tag2='" + tag2 + '\'' +
				", tag3='" + tag3 + '\'' +
				", tag4='" + tag4 + '\'' +
				", tag5='" + tag5 + '\'' +
				'}';
	}
}
