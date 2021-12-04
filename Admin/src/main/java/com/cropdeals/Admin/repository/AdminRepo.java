package com.cropdeals.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeals.Admin.models.Admin;



public interface AdminRepo  extends MongoRepository<Admin, String> {

}
