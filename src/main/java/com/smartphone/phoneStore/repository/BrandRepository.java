package com.smartphone.phoneStore.repository;

import com.smartphone.phoneStore.entity.BrandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BrandRepository extends MongoRepository<BrandEntity, String> {
    List<BrandEntity> findByBrandValue(String brandValue);
}