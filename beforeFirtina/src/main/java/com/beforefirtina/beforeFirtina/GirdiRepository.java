package com.beforefirtina.beforeFirtina;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GirdiRepository extends MongoRepository<GirdiMetinDoc, ObjectId> {
}
