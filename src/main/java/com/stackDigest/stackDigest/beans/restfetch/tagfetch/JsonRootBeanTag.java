package com.stackDigest.stackDigest.beans.restfetch.tagfetch;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonRootBeanTag {

	private List<Items> items;
	@JsonProperty("has_more")
	private boolean hasMore;
	@JsonProperty("quota_max")
	private int quotaMax;
	@JsonProperty("quota_remaining")
	private int quotaRemaining;
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public List<Items> getItems() {
		return items;
	}

	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	public boolean getHasMore() {
		return hasMore;
	}

	public void setQuotaMax(int quotaMax) {
		this.quotaMax = quotaMax;
	}
	public int getQuotaMax() {
		return quotaMax;
	}

	public void setQuotaRemaining(int quotaRemaining) {
		this.quotaRemaining = quotaRemaining;
	}
	public int getQuotaRemaining() {
		return quotaRemaining;
	}

}
