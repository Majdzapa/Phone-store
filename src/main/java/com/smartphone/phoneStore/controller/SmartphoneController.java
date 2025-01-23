package com.smartphone.phoneStore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartphone.phoneStore.dto.SmartPhoneDTO;
import com.smartphone.phoneStore.service.SmartPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smartphones")
public class SmartphoneController {

    private final SmartPhoneService smartPhoneService;


    @GetMapping("/{reference}")
    public ResponseEntity<SmartPhoneDTO> getSmartPhoneByReference(@PathVariable String reference) throws IOException, InterruptedException {

        SmartPhoneDTO smartPhoneDTO = smartPhoneService.getSmartPhoneByReference(reference);
        return ResponseEntity.ok(smartPhoneDTO);
    }


    @PostMapping("/save")
    public ResponseEntity<String> saveSmartPhone(
            @RequestParam ("smartPhoneDTO") String smartPhoneDTOJson,
            @RequestPart("image") MultipartFile image) {
        try {
            SmartPhoneDTO smartPhoneDTO = convertJsonToDTO(smartPhoneDTOJson);
            smartPhoneService.saveSmartPhone(smartPhoneDTO,image);

            return ResponseEntity.status(HttpStatus.CREATED).body("Smartphone  saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving smartphone: " + e.getMessage());
        }


    }
    private SmartPhoneDTO convertJsonToDTO(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SmartPhoneDTO s = objectMapper.readValue(json, SmartPhoneDTO.class);
            System.out.println(s.toString());
            return objectMapper.readValue(json, SmartPhoneDTO.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON to SmartPhoneDTO", e);
        }
    }


}
