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
	
	@PostMapping("/addDealer")
	public void placeOrder( @RequestBody Dealer order ) {
		repos.insert( order );
	}
	
	@PostMapping("/addcrop")
	public void placeOrders(@RequestBody Crops crop ) {
		restTemplate.postForEntity("http://localhost:8084/crops/addCrop", crop, Crops.class);
	}

	
	@GetMapping("/all")
	public List<Dealer> showAllOrders() {
		return repos.findAll();		
	}
	
	 
	@GetMapping("/allmycrops/{farmerId}")
	public ReturnAllCrops showMyCrops(@PathVariable String farmerId) {
		return  restTemplate.getForObject("http://localhost:8084/crops/findmycrop/"+farmerId, ReturnAllCrops.class);
	}

	@GetMapping("/finddealer/{itemName}")
	public Dealer findOrder ( @PathVariable String itemName ){
		return repos.findOrdersByName( itemName );
	}
	
	@PutMapping("/update/{id}")
    public String updateOrder(@RequestBody Dealer dealer, @PathVariable String id) {
		dealer.setId( id );
		repos.save(dealer);
        return ("Updated Successfully");
    }
		
	@GetMapping("/delete/{id}")
	public String deleteOrder( @PathVariable String id )	{
		repos.deleteById( id );
		return ("Deleted Successfully");
	}

	
}
