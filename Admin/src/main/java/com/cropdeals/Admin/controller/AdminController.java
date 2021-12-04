package com.cropdeals.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cropdeals.Admin.models.Crops;
import com.cropdeals.Admin.models.FarmerProfile;
import com.cropdeals.Admin.models.ReturnAllCrops;
import com.cropdeals.Admin.repository.AdminRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController {

		@Autowired
		AdminRepo  adminRepo;
		
		@Autowired
		RestTemplate restTemplate;
		
		/*@Autowired
		ProfileServices profileServices;
		
		@Bean
		public void addtoServiceclass() {
			profileServices.addlist(profileRepo.findAll());
		} */
		
		@PostMapping("/addfarmer")
		public void addFarmer( @RequestBody FarmerProfile farmerProfile ) {
			restTemplate.postForEntity("http://localhost:8081/farmer/addfarmer", farmerProfile,FarmerProfile.class);
		}
		
		@PostMapping("/addcrop")
		public void addCrops(@RequestBody Crops crop ) {
			restTemplate.postForEntity("http://localhost:8084/crops/addcrop", crop,Crops.class);
		}

	//	@GetMapping("/allfarmers")
//		public List<FarmerProfile> showAllFarmers() {
	//		return profileRepo.findAll();		
//		}
		
		
		@GetMapping("/allmycrops/{farmerId}")
		public ReturnAllCrops showMyCrops(@PathVariable String farmerId) {
			
			return  restTemplate.getForObject("http://localhost:8084/crops/findmycrop/"+farmerId, ReturnAllCrops.class);
			
		}
		
		@GetMapping("/allcrops")
		public List<Crops> showAllCrops() {
			
			ReturnAllCrops allCrops = restTemplate.getForObject("http://localhost:8084/crops/allcrops", ReturnAllCrops.class);
			return allCrops.getListOfCrops();
		}
		
	/*	@GetMapping("/findfarmer/{farmerName}")
		public FarmerProfile findfarmer ( @PathVariable String farmerName ){
			return profileRepo.findfarmerByName( farmerName );
		}
		
		@PutMapping("/update/{id}")
	    public String updateOrder(@RequestBody FarmerProfile order, @PathVariable String id) {
	        order.setId( id );
	        profileRepo.save(order);
	        return ("Updated Successfully");
	    }*/
		
		@GetMapping("/deletecrop/{id}")
		public String deleteCrop( @PathVariable String id )	{
			
			 return restTemplate.getForObject("http://localhost:8084/crops/delete/"+id, String.class);

		}
		
		@GetMapping("/deletefarmer/{id}")
		public String deleteFarmer( @PathVariable String id )	{
			 return restTemplate.getForObject("http://localhost:8081/farmer/deletefarmer/"+id, String.class);
		}
}
