package com.stackDigest.stackDigest.entity.QuestionsAll;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonRootBean {

	private List<Items> items;
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public List<Items> getItems() {
		return items;
	}

}
