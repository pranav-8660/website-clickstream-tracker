package com.pranavv51.storage_service.repository;


import com.pranavv51.storage_service.model.ProcessedEventModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProcessedEventRepository extends MongoRepository<ProcessedEventModel,String> {
}
