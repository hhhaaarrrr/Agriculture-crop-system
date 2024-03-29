package com.cropdeals.FarmerApi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cropdeals.FarmerApi.models.FarmerProfile;
 
@Repository
public interface ProfileRepo extends MongoRepository<FarmerProfile, String > {

	
	
	
	@Query("{ 'fName' : ?0 }")
	FarmerProfile findfarmerByName(String farmerName);

	FarmerProfile findByfName(String username);

	

	

}
