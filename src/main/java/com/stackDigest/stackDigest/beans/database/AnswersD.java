package com.stackDigest.stackDigest.beans.database;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "answersd")
@PrimaryKeyJoinColumn(name = "aId")
@javax.persistence.Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AnswersD extends OwnerD {
	@Column
	int score;
	@Column
	int creationDate;
	@Lob
	String body;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(int creationDate) {
		this.creationDate = creationDate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Answer{" +
				"score=" + score +
				", creationDate=" + creationDate +
				", body='" + body + '\'' +
				'}';
	}
}
