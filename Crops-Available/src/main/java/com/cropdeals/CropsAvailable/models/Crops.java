package com.cropdeals.CropsAvailable.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Crops {
	@Id
	private String id;
	private String farmerID;
	private String cropName; 
 
	private int qty;
  
	public Crops(String id, String farmerID, String cropName, int qty) {
		super();
		this.id = id;
		this.farmerID = farmerID;
		this.cropName = cropName;
		this.qty = qty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getFarmerID() {
		return farmerID;
	}
	public void setFarmerID(String farmerID) {
		this.farmerID = farmerID;
	}

}
