package com.stackDigest.stackDigest.beans.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Owner {

	@Id
	private int assetId;
	@Column
	private String profileImage;
	@Column
	private String displayName;
	@Column
	private String ownerLink;

	public Owner() {
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getDisplayName() {    
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getOwnerLink() {
		return ownerLink;
	}

	public void setOwnerLink(String ownerLink) {
		this.ownerLink = ownerLink;
	}
}
