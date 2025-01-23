package com.smartphone.phoneStore.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "brands")
public class BrandEntity {
    @Id
    private String id;
    private String brandValue;
}