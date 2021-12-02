package com.cropdeals.CropsAvailable.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cropdeals.CropsAvailable.models.Crops;

@Repository
public interface CropRepo extends MongoRepository<Crops, String> {
 
	
	@Query("{'farmerID' :?0}")
	List<Crops> findAllById(String id);

	
	
}
