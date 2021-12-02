package com.cropdeals.FarmerApi.models;

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
 

	public FarmerProfile(String id, int farmerID, String fName, String fPassword, String fAccountNo) {
		super();
		this.id = id;
		this.farmerID = farmerID;
		this.fName = fName;
		this.fPassword = fPassword;
		this.fAccountNo = fAccountNo;
	}

	public int getFarmerID() {
		return farmerID;
	}

	public void setFarmerID(int farmerID) {
		this.farmerID = farmerID;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
 	
}
