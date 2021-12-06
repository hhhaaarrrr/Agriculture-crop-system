package com.cropdeals.Admin.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Crops {
	@Id
	private String id;
	private String farmerID;
	private String cropName;
	private String cropType;
	private String location;
	private int qty;
	private List<String> dealersId = new ArrayList<String>();
	
	
	public Crops() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Crops(String id, String farmerID, String cropName, String cropType, String location, int qty,
			List<String> dealersId) {
		super();
		this.id = id;
		this.farmerID = farmerID;
		this.cropName = cropName;
		this.cropType = cropType;
		this.location = location;
		this.qty = qty;
		this.dealersId = dealersId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFarmerID() {
		return farmerID;
	}
	public void setFarmerID(String farmerID) {
		this.farmerID = farmerID;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public List<String> getDealersId() {
		return dealersId;
	}
	public void setDealersId(List<String> dealersId) {
		this.dealersId = dealersId;
	}
	
	@Override
	public String toString() {
		return "Crops [id=" + id + ", farmerID=" + farmerID + ", cropName=" + cropName + ", cropType=" + cropType
				+ ", location=" + location + ", qty=" + qty + ", dealersId=" + dealersId + "]";
	}
	
}
