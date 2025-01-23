package com.smartphone.phoneStore.entity;


import org.openapitools.model.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "phone_specs")
public class PhoneSpecsEntity {
    @Id
    private String id;
    private PhoneDetailsDTO phoneDetails;
    private GsmNetworkDetailsDTO gsmNetworkDetails;
    private GsmLaunchDetailsDTO gsmLaunchDetails;
    private GsmBodyDetailsDTO gsmBodyDetails;
    private GsmDisplayDetailsDTO gsmDisplayDetails;
    private GsmPlatformDetailsDTO gsmPlatformDetails;
    private GsmMemoryDetailsDTO gsmMemoryDetails;
    private GsmCameraDetailsDTO gsmCameraDetails;
    private GsmSoundDetailsDTO gsmSoundDetails;
    private GsmCommunicationsDetailsDTO gsmCommunicationsDetails;
    private GsmFeaturesDetailsDTO gsmFeaturesDetails;
    private GsmBatteryDetailsDTO gsmBatteryDetails;
    private GsmMiscDetailsDTO gsmMiscDetails;
    private GsmTestsDetailsDTO gsmTestsDetails;
}