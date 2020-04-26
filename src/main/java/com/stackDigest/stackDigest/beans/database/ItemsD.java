package com.stackDigest.stackDigest.beans.database;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "qId")
public class ItemsD extends OwnerD {
	@Column
	private int score;
	@Column
	private String link;
	@Lob
	private String body;
	@Column
	private String title;
	@ElementCollection
	private Set<String> tags;
	@OneToOne(cascade = CascadeType.ALL)
	AnswersD answersD;



	public AnswersD getAnswersD() {
		return answersD;
	}

	public void setAnswersD(AnswersD answersD) {
		this.answersD = answersD;
	}

	public ItemsD() {
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

	@Override
	public String toString() {
		return "Items{" +
				"score=" + score +
				", link='" + link + '\'' +
				", body='" + body + '\'' +
				", title='" + title + '\'' +
				", tags=" + tags +
				", answer=" + answersD +
				'}';
	}
}
