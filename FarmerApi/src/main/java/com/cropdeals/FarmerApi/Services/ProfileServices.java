package com.cropdeals.FarmerApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cropdeals.FarmerApi.models.FarmerProfile;
import com.cropdeals.FarmerApi.repository.ProfileRepo;
 

@Service
public class ProfileServices {
	
	@Autowired
	ProfileRepo profileRepo;
	
	public void addfarmer(FarmerProfile farmerProfiles) {
		
		profileRepo.insert(farmerProfiles);
		
	}
	
	List<FarmerProfile> farmerProfiles;
	 
	
	public void addlist(List<FarmerProfile> farmerProfiles) {
		 this.farmerProfiles = farmerProfiles;
	}


	public List<FarmerProfile> findAll() {
		
		return profileRepo.findAll();
	}


	
	
 

}
