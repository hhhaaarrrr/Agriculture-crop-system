package com.cropdeals.FarmerApi.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cropdeals.FarmerApi.models.FarmerProfile;
 

@Service
public class ProfileServices {
	
	List<FarmerProfile> farmerProfiles;
	 
	
	public void addlist(List<FarmerProfile> farmerProfiles) {
		 this.farmerProfiles = farmerProfiles;
	}
	
 

}
