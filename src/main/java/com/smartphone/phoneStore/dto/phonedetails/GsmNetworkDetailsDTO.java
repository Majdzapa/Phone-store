package com.smartphone.phoneStore.dto.phonedetails;

import lombok.Data;

@Data
public class GsmNetworkDetailsDTO {
    private String networkTechnology;
    private String network2GBands;
    private String network3GBands;
    private String network4GBands;
    private String network5GBands;
    private String networkSpeed;
}