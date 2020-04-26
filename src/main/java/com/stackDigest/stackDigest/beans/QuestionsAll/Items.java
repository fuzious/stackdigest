package com.stackDigest.stackDigest.beans.QuestionsAll;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class Items {


    private List<Answers> answers;
    private Owner owner;
    private Set<String> tags;
    @JsonProperty("accepted_answer_id")
    private int acceptedAnswerId;
    private int score;
    @JsonProperty("question_id")
    private int questionId;
    private String link;
    private String title;
    private String body;
    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
    public Set<String> getTags() {
        return tags;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }
    public List<Answers> getAnswers() {
        return answers;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setAcceptedAnswerId(int acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }
    public int getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public int getQuestionId() {
        return questionId;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public String getLink() {
        return link;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Items{" +
                "answers=" + answers +
                ", owner=" + owner +
                ", tags=" + tags +
                ", acceptedAnswerId=" + acceptedAnswerId +
                ", score=" + score +
                ", questionId=" + questionId +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
