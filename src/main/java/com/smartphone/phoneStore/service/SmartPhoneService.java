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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmartPhoneService {

    private final SmartPhoneRepository smartPhoneRepository;
    private final ModelMapper modelMapper;

    public SmartPhoneDTO getSmartPhoneByReference(String reference) {

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
