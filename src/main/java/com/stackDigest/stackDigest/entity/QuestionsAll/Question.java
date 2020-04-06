package com.stackDigest.stackDigest.entity.QuestionsAll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    Items[] items;

    public Question() {}
    public Question(Items[] items) {
        this.items = items;
    }

    public Items[] getItems() {
        return items;
    }

    public void setItems(Items[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Question{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
