package com.smartphone.phoneStore.dto;

import com.smartphone.phoneStore.dto.phonedetails.*;
import lombok.Data;

@Data
public class PhoneSpecsResponseDTO {
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
