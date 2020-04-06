package com.stackDigest.stackDigest.entity.QuestionsAll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    private String[] tags;
    private Owner owner;
    private boolean is_answered;
    private int view_count;
    private int answer_count;
    private int score;
    private String last_activity_date;
    private String creation_date;
    private String last_edit_date;
    private int question_id;
    private String link;
    private String title;

    public Items() {}

    public Items(String[] tags, Owner owner, boolean is_answered, int view_count, int answer_count, int score, String last_activity_date, String creation_date, String last_edit_date, int question_id, String link, String title) {
        this.tags = tags;
        this.owner = owner;
        this.is_answered = is_answered;
        this.view_count = view_count;
        this.answer_count = answer_count;
        this.score = score;
        this.last_activity_date = last_activity_date;
        this.creation_date = creation_date;
        this.last_edit_date = last_edit_date;
        this.question_id = question_id;
        this.link = link;
        this.title = title;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isIs_answered() {
        return is_answered;
    }

    public void setIs_answered(boolean is_answered) {
        this.is_answered = is_answered;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(String last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getLast_edit_date() {
        return last_edit_date;
    }

    public void setLast_edit_date(String last_edit_date) {
        this.last_edit_date = last_edit_date;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Items{" +
                "tags=" + Arrays.toString(tags) +
                ", owner=" + owner +
                ", is_answered=" + is_answered +
                ", view_count=" + view_count +
                ", answer_count=" + answer_count +
                ", score=" + score +
                ", last_activity_date='" + last_activity_date + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", last_edit_date='" + last_edit_date + '\'' +
                ", question_id=" + question_id +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
