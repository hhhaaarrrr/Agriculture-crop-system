package com.cropdeals.DealerApi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cropdeals.DealerApi.models.Crops;
import com.cropdeals.DealerApi.models.Dealer;
import com.cropdeals.DealerApi.models.FarmerProfile;
import com.cropdeals.DealerApi.models.ReturnAllCrops;
import com.cropdeals.DealerApi.repository.DealerRepo;
 
 

@RestController
@EnableEurekaClient
@RequestMapping("/dealer")
public class DealerController {

	@Autowired
	DealerRepo repos;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/adddealer")
	public void placedealer( @RequestBody Dealer dealer ) {
		repos.insert( dealer );
	}
	

	@GetMapping("/all")
	public List<Dealer> showAlldealers() {
		return repos.findAll();		
	}
	
	 
	@GetMapping("/allmycrops/{farmerId}")
	public ReturnAllCrops showMyCrops(@PathVariable String farmerId) {
		return  restTemplate.getForObject("http://crop-avalilable/crops/findmycrop/"+farmerId, ReturnAllCrops.class);
	}

	@PutMapping("/giverating/{id}")
    public String giveRatings(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
	 
	restTemplate.put("http://FarmerApi/farmer/rating/"+id, farmerProfile);
	return "rated successfully";
    }
	
	@PutMapping("/buycrop/{id}")
    public String buycrop(@RequestBody FarmerProfile farmerProfile, @PathVariable String id) {
	 
	restTemplate.put("http://crop-avalilable/crops/buycrop/"+id, farmerProfile);
	return "requested successfully";
    }
	
	
	
	@GetMapping("/finddealer/{dealerName}")
	public Dealer finddealer ( @PathVariable String dealerName ){
		return repos.finddealerByName( dealerName );
	}
	
	@PutMapping("/update/{id}")
    public String updatedealer(@RequestBody Dealer dealer, @PathVariable String id) {
		dealer.setId( id );
		repos.save(dealer);
        return ("Updated Successfully");
    }
		
	@GetMapping("/delete/{id}")
	public String deletedealer( @PathVariable String id )	{
		repos.deleteById( id );
		return ("Deleted Successfully");
	}

	
}
