package com.cropdeals.CropsAvailable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeals.CropsAvailable.models.Crops;
import com.cropdeals.CropsAvailable.models.ReturnAllCrops;
import com.cropdeals.CropsAvailable.repository.CropRepo;
import com.cropdeals.CropsAvailable.service.CropService;


@RestController
@RequestMapping("/crops")
public class CropController {

	@Autowired
	CropRepo repos;
	
	@Autowired
	CropService  cropService;
	
	@Autowired
	ReturnAllCrops returnAllCrops;
	
	
	//adding crops
	@PostMapping("/addcrop")
	public void addCrops( @RequestBody Crops crop ) {
		repos.insert( crop );
		
	}
	
	//getting all crops
	@GetMapping("/allcrops")
	public List<Crops> getAllCrops() {
		return repos.findAll();
	}
 
	//finding crops by using farmerid
	
	@GetMapping("/findmycrop/{id}")
	public ReturnAllCrops findmycrop( @PathVariable String id ){
		returnAllCrops.setListOfCrops(repos.findAllById( id ));
		return returnAllCrops;
	}
	
	
	@PutMapping("/buycrop/{id}")
    public void buyCrop(@RequestBody Crops crop,@PathVariable("id") String id) {
        crop.setId( id );
        
        repos.save(crop);
     }
	
	
	//updating crop
	@PutMapping("/update/{id}")
    public String updatecrop(@RequestBody Crops crop, @PathVariable String id) {
        crop.setId( id );
        repos.save(crop);
        return ("Updated Successfully");
    }
		
	//deleting crop
	@GetMapping("/delete/{id}")
	public String deletecrop( @PathVariable String id )	{
		repos.deleteById(id);
		return ("Deleted Successfully");
	}
	
	
}
