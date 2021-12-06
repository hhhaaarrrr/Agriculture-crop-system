package com.cropdeals.Admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@EnableEurekaClient
@RequestMapping("/admin")
public class AdminController {

		@Autowired
		AdminRepo  adminRepo;
		
		@Autowired
		RestTemplate restTemplate;
		
		
		@PostMapping("/addfarmer")
		public void addFarmer( @RequestBody FarmerProfile farmerProfile ) {
			restTemplate.postForEntity("http://FarmerApi/farmer/addfarmer", farmerProfile,FarmerProfile.class);
		}
		
		
		@GetMapping("/allfarmers")
		public String showAllFarmerProfile() {
			return restTemplate.getForObject("http://FarmerApi/farmer/allfarmers", String.class);
		}	
		
		
		@PostMapping("/addcrop")
		public void addCrops(@RequestBody Crops crop ) {
			restTemplate.postForEntity("http://crop-avalilable/crops/addcrop", crop,Crops.class);
		}

	
		@GetMapping("/allmycrops/{farmerId}")
		public ReturnAllCrops showMyCrops(@PathVariable String farmerId) {
			
			return  restTemplate.getForObject("http://crop-avalilable/crops/findmycrop/"+farmerId, ReturnAllCrops.class);
			
		}
		
		@GetMapping("/allcrops")
		public String showAllCrops() {
			
			return restTemplate.getForObject("http://crop-avalilable/crops/allcrops", String.class);
		
	
		}
		
		
		@GetMapping("/deletecrop/{id}")
		public String deleteCrop( @PathVariable String id )	{
			
			 return restTemplate.getForObject("http://crop-avalilable/crops/delete/"+id, String.class);

		}
		
		@GetMapping("/deletefarmer/{id}")
		public String deleteFarmer( @PathVariable String id )	{
			 return restTemplate.getForObject("http://FarmerApi/farmer/deletefarmer/"+id, String.class);
		}
}
