package com.stackDigest.stackDigest.beans.restfetch.QuestionsAll;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answers {

	private Owner owner;
	@JsonProperty("is_accepted")
	private boolean isAccepted;
	private int score;
	@JsonProperty("creation_date")
	private int creationDate;
	private String body;
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Owner getOwner() {
		return owner;
	}

	public void setIsAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public boolean getIsAccepted() {
		return isAccepted;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}

	public void setCreationDate(int creationDate) {
		this.creationDate = creationDate;
	}
	public int getCreationDate() {
		return creationDate;
	}

	public void setBody(String body) {
		this.body = body;
	}
	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "Answers{" +
				"owner=" + owner +
				", isAccepted=" + isAccepted +
				", score=" + score +
				", creationDate=" + creationDate +
				", body='" + body + '\'' +
				'}';
	}
}
