package com.cropdeals.DealerApi.models;

import java.util.List;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dealer {

	@Id
	private String id;
	private String dealerName;
	private String subscriberCrop;
	private int rating;
	private List<Integer> noOfRatings;
	
	
	public Dealer(String id, String dealerName, String subscriberCrop, int rating, List<Integer> noOfRatings) {
		super();
		this.id = id;
		this.dealerName = dealerName;
		this.subscriberCrop = subscriberCrop;
		this.rating = rating;
		this.noOfRatings = noOfRatings;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getSubscriberCrop() {
		return subscriberCrop;
	}
	public void setSubscriberCrop(String subscriberCrop) {
		this.subscriberCrop = subscriberCrop;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public List<Integer> getNoOfRatings() {
		return noOfRatings;
	}
	public void setNoOfRatings(List<Integer> noOfRatings) {
		this.noOfRatings = noOfRatings;
	} 
	
	
}
