package com.smartphone.phoneStore.dto.phonedetails;

import lombok.Data;

@Data
public class GsmCommunicationsDetailsDTO {
    private String communicationsBluetooth;
    private String communicationsNfc;
    private String communicationsPositioning;
    private String communicationsRadio;
    private String communicationsUsb;
    private String communicationsWlan;
}
