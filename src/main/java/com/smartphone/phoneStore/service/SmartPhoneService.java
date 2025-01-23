package com.smartphone.phoneStore.service;

import com.smartphone.phoneStore.dto.SmartPhoneDTO;
import com.smartphone.phoneStore.ecxeption.ReferenceNotFoundException;
import com.smartphone.phoneStore.entity.SmartPhoneEntity;
import com.smartphone.phoneStore.repository.SmartPhoneRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmartPhoneService {

    private final SmartPhoneRepository smartPhoneRepository;
    private final ModelMapper modelMapper;

    public SmartPhoneDTO getSmartPhoneByReference(String reference) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://mobile-phone-specs-database.p.rapidapi.com/gsm/get-models-by-brandname/Samsung"))
                .header("x-rapidapi-key", "4c9a9eb06amsh18a6a44a3915cfcp1c27edjsnd3d7c7f4108d")
                .header("x-rapidapi-host", "mobile-phone-specs-database.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return smartPhoneRepository.findByReference(reference)
                .map(entity -> modelMapper.map(entity, SmartPhoneDTO.class))
                .orElseThrow(() -> new ReferenceNotFoundException(reference));


    }

    public void saveSmartPhone(SmartPhoneDTO smartPhoneDto,MultipartFile image) throws IOException {
        SmartPhoneEntity smartPhoneEntity = convertToEntity(smartPhoneDto,image);
        smartPhoneRepository.save(smartPhoneEntity);
    }


    private SmartPhoneEntity convertToEntity(SmartPhoneDTO dto, MultipartFile image) throws IOException {
        byte[] imageBytes = image != null ? image.getBytes() : null;

       return SmartPhoneEntity.builder()
                .reference(dto.getReference())
                .os(dto.getOs())
                .image(imageBytes)
                .brand(dto.getBrand())
                .model(dto.getModel())
                .description(dto.getDescription())
               .build();
    }
}
