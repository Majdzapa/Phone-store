package com.smartphone.phoneStore.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
public class SmartPhoneDTO {

    private String reference;
    private String brand;
    private String model;
    private String os;
    private byte[] image;
    private String description;
}