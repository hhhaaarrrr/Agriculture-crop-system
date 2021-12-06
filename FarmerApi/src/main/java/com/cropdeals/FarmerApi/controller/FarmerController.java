package com.cropdeals.FarmerApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
import com.cropdeals.FarmerApi.Services.ProfileServices;
import com.cropdeals.FarmerApi.exception.ApiRequestException;
import com.cropdeals.FarmerApi.models.FarmerProfile;
import com.cropdeals.FarmerApi.models.ReturnAllCrops;
import com.cropdeals.FarmerApi.models.AuthenticationResponse;
import com.cropdeals.FarmerApi.models.Crops;
import com.cropdeals.FarmerApi.repository.ProfileRepo;
 

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProfileServices profileServices;
	
	@Autowired
	ProfileRepo profileRepo;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/addfarmer")
	public String addfarmer( @RequestBody FarmerProfile farmerProfile ) {
		profileRepo.save( farmerProfile );
		return "farmer added";
	}
	
	@PostMapping("/auth")
	private ResponseEntity<?> authfarmer(@RequestBody  FarmerProfile farmerProfile){
	String Name = farmerProfile.getfName();
	String Password = farmerProfile.getfPassword ();
	try {
	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Name, Password));

	} catch (Exception e) {

	return ResponseEntity.ok(new AuthenticationResponse("Error during customer Authentication"+ Name));
	}
	return ResponseEntity.ok(new AuthenticationResponse("Successfully Authenticated customer "+ Name));

	}
	
	@PostMapping("/addcrop")
	public void addCrops(@RequestBody Crops crop ) {
		restTemplate.postForEntity("http://crop-avalilable/crops/addcrop", crop , Crops.class);
	} 

	@GetMapping("/allfarmers")
	public List<FarmerProfile> showAllFarmers() {
		return profileRepo.findAll();		
	}
	
	
	
	@GetMapping("/allmycrops/{farmerId}")
	public ReturnAllCrops showMyCrops(@PathVariable String farmerId) {
		
		return  restTemplate.getForObject("http://crop-avalilable/crops/findmycrop/"+farmerId, ReturnAllCrops.class);
		
	}
	
	@GetMapping("/allcrops")
	public String showAllCrops() {
		
		return restTemplate.getForObject("http://crop-avalilable/crops/allcrops", String.class);
		
	}
	
	@GetMapping("/findfarmer/{farmerName}")
	public FarmerProfile findfarmer ( @PathVariable String farmerName ){
		return profileRepo.findfarmerByName( farmerName );
	}
	
	@PutMapping("/rating/{id}")
    public void giveRating(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
        farmerProfile.setId( id );  
        Integer rating= farmerProfile.getAllRatings().stream().mapToInt(Integer::intValue).sum()/farmerProfile.getAllRatings().size();
        farmerProfile.setRating(rating);
        profileRepo.save(farmerProfile);
    }
	
	
	@PutMapping("/update/{id}")
    public String updateOrder(@RequestBody FarmerProfile order, @PathVariable String id) {
        order.setId( id );
        profileRepo.save(order);
        return ("Updated Successfully");
    }
	
	@GetMapping("/deletecrop/{id}")
	public String deleteCrop( @PathVariable String id )	{
		
		 return restTemplate.getForObject("http://crop-avalilable/crops/delete/"+id, String.class);

	}
	
	
	
	
	
	@GetMapping("/deletefarmer/{id}")
	public String deleteFarmer( @PathVariable String id )	{
	{
		boolean isfarmerExist= profileRepo.existsById(id);
		if(isfarmerExist) {
			profileRepo.deleteById( id );
			return ("Deleted Successfully");
		}
		else
		{
			throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		}

	}	
}

}