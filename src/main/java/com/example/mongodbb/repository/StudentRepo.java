package com.example.mongodbb.repository;

import com.example.mongodbb.entity.StudentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<StudentEntity,ObjectId> {
}
