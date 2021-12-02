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
 

@RestController
@RequestMapping("/crops")
public class CropController {

	@Autowired
	CropRepo repos;
	@Autowired
	ReturnAllCrops returnAllCrops;
	
	@PostMapping("/addcrop")
	public void addCrops( @RequestBody Crops crop ) {
		repos.insert( crop );
	}
	
	@GetMapping("/allcrops")
	public ReturnAllCrops showAllCrps() {
		returnAllCrops.setListOfCrops(repos.findAll());
		return returnAllCrops;		
	}
 
	@GetMapping("/findmycrop/{id}")
	public ReturnAllCrops findmycrop( @PathVariable String id ){
		returnAllCrops.setListOfCrops(repos.findAllById( id ));
		return returnAllCrops;
	}
	
	@PutMapping("/update/{id}")
    public String updateOrder(@RequestBody Crops crop, @PathVariable String id) {
        crop.setId( id );
        repos.save(crop);
        return ("Updated Successfully");
    }
		
	@GetMapping("/delete/{id}")
	public String deleteOrder( @PathVariable String id )	{
		repos.deleteById(id);
		return ("Deleted Successfully");
	}
	
	
}
