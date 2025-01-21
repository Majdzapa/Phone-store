package com.smartphone.phoneStore.repository;

import com.smartphone.phoneStore.entity.SmartPhoneEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SmartPhoneRepository extends MongoRepository<SmartPhoneEntity, String> {
    Optional<SmartPhoneEntity> findByReference(String reference);
}