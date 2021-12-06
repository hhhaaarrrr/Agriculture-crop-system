package com.cropdeals.DealerApi.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FarmerProfile {
	
	@Id
	private String id;
	private int farmerID;
	private String fName;
	private String fPassword;
	private String fAccountNo;
	private int rating;
	private List<Integer> allRatings;
	
	
	
	
	
	public FarmerProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FarmerProfile(String id, int farmerID, String fName, String fPassword, String fAccountNo, int rating,
			List<Integer> allRatings) {
		super();
		this.id = id;
		this.farmerID = farmerID;
		this.fName = fName;
		this.fPassword = fPassword;
		this.fAccountNo = fAccountNo;
		this.rating = rating;
		this.allRatings = allRatings;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFarmerID() {
		return farmerID;
	}
	public void setFarmerID(int farmerID) {
		this.farmerID = farmerID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfPassword() {
		return fPassword;
	}
	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}
	public String getfAccountNo() {
		return fAccountNo;
	}
	public void setfAccountNo(String fAccountNo) {
		this.fAccountNo = fAccountNo;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public List<Integer> getAllRatings() {
		return allRatings;
	}
	public void setAllRatings(List<Integer> allRatings) {
		this.allRatings = allRatings;
	}
	@Override
	public String toString() {
		return "FarmerProfile [id=" + id + ", farmerID=" + farmerID + ", fName=" + fName + ", fPassword=" + fPassword
				+ ", fAccountNo=" + fAccountNo + ", rating=" + rating + ", allRatings=" + allRatings + "]";
	}

	
}
