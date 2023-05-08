package com.beforefirtina.beforeFirtina;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BirlesikRepository extends MongoRepository<BirlesikMetinDoc, ObjectId> {

    //BirlesikMetinler koleksiyonundaki son dökümanı çağırmak için
    Optional<BirlesikMetinDoc> findFirstByOrderByIdDesc();
}
