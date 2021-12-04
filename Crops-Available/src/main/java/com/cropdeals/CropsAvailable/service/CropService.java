package com.cropdeals.CropsAvailable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.cropdeals.CropsAvailable.models.Crops;
import com.cropdeals.CropsAvailable.repository.CropRepo;

@Service
public class CropService {

	@Autowired
	CropRepo repos;

	
	public List<Crops> getCrops(String farmerId) {
		List<Crops> crops=repos.findAll();
		System.out.println("Getting crops from DB" + crops);
        return crops;
		}
	
	
		

	
}	
	

