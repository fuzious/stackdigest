package com.stackDigest.stackDigest.entity.database;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items")
public class Items {
	@Id
	@Column
	private int questionId;
	@Column
	private int score;
	@Column
	private String link;
	@Column
	private String body;
	@Column
	private String title;
	@ElementCollection
	private Set<String> tags;

	public Items() {
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
}
