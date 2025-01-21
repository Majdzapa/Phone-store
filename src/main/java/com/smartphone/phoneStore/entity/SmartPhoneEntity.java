package com.smartphone.phoneStore.entity;


import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "smartphones")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class SmartPhoneEntity {
    @Id
    private String reference;
    private String brand;
    private String model;
    private String os;
    private byte[] image;
    private String description;
}
