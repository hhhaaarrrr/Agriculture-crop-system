package com.cropdeals.FarmerApi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


import com.cropdeals.FarmerApi.models.FarmerProfile;
import com.cropdeals.FarmerApi.repository.ProfileRepo;
 

@Service
public class ProfileServices implements UserDetailsService {
	
	@Autowired
	ProfileRepo profileRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	FarmerProfile foundedfarmer = profileRepo.findByfName(username);

	if (foundedfarmer ==null) return null;
	String fName = foundedfarmer.getfName();
	String fPassword = foundedfarmer.getfPassword();
	return new User(fName, fPassword, new ArrayList<>());
	}
	
	
	/*public List<FarmerProfile> getFarmerProfiles() {
		List<FarmerProfile> farmerProfiles = profileRepo.findAll();
		System.out.println("Getting Farmers from DB" + farmerProfiles);
		return farmerProfiles;
	}
	public farmer addfarmer(farmer Farmer) {
		// TODO Auto-generated method stub
		return farmerRepo.save(Farmer);
	}
	
	
	
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


	public void save(FarmerProfile order) {
		// TODO Auto-generated method stub
		
	}
*/

	


	
	
	
 

}
