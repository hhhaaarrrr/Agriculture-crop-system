package com.cropdeals.DealerApi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cropdeals.DealerApi.models.Dealer;

public interface DealerRepo extends MongoRepository<Dealer, String>{

	
	@Query("{'dealerName' : ?0}")
	Dealer findOrdersByName(String itemName);

}
