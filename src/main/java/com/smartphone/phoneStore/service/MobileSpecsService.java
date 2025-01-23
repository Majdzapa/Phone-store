package com.smartphone.phoneStore.service;

import com.smartphone.phoneStore.dto.BrandDTO;
import com.smartphone.phoneStore.dto.PhoneSpecsResponseDTO;
import com.smartphone.phoneStore.entity.BrandEntity;
import com.smartphone.phoneStore.entity.PhoneSpecsEntity;
import com.smartphone.phoneStore.feign.MobileSpecsClient;
import com.smartphone.phoneStore.repository.BrandRepository;
import com.smartphone.phoneStore.repository.PhoneSpecsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MobileSpecsService {

    private final MobileSpecsClient mobileSpecsClient;
    private final BrandRepository brandRepository;
    private final PhoneSpecsRepository phoneSpecsRepository;


    public List<BrandDTO> fetchAllBrands() {
        return mobileSpecsClient.getAllBrands();
    }

    public PhoneSpecsResponseDTO fetchPhoneSpecsByCustomId(int customId) {
        return mobileSpecsClient.getPhoneSpecsByCustomId(customId);
    }

    public List<BrandDTO> saveFetchedAllBrands() {
        List<BrandDTO> brands = mobileSpecsClient.getAllBrands();
        // Save brands to MongoDB
        brands.forEach(brand -> {
            BrandEntity entity = new BrandEntity();
            entity.setBrandValue(brand.getBrandValue());
            brandRepository.save(entity);
        });
        return brands;
    }

    public PhoneSpecsResponseDTO saveFetchPhoneSpecsByCustomId(int customId) {
        PhoneSpecsResponseDTO specs = mobileSpecsClient.getPhoneSpecsByCustomId(customId);
        // Save phone specs to MongoDB
        PhoneSpecsEntity entity = new PhoneSpecsEntity();
        entity.setPhoneDetails(specs.getPhoneDetails());
        entity.setGsmNetworkDetails(specs.getGsmNetworkDetails());
        // Set other fields...
        phoneSpecsRepository.save(entity);
        return specs;
    }
}