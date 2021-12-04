package com.cropdeals.Admin.models;

public class Admin {
	
	int id;
	String  adminName;
	
	
	public Admin(int id, String adminName) {
		super();
		this.id = id;
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


}
