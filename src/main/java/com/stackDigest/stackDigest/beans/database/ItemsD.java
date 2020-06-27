package com.stackDigest.stackDigest.beans.database;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "qId")
@javax.persistence.Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemsD extends OwnerD {
	@Column
	private int score;
	@Column
	private String link;
	@Lob
	private String body;
	@Column
	private String title;

	//optimising search via BTree indexed tags
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(length = 30)
	@CollectionTable(indexes = @Index(name = "index_tags", columnList = "tags"))
	private Set<String> tags;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
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
