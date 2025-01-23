package com.smartphone.phoneStore.repository;

import com.smartphone.phoneStore.entity.PhoneSpecsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface PhoneSpecsRepository extends MongoRepository<PhoneSpecsEntity, String> {
    Optional<PhoneSpecsEntity> findByPhoneDetails_CustomId(int customId);
}