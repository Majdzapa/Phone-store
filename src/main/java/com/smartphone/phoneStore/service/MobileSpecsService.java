package com.smartphone.phoneStore.service;

import com.smartphone.phoneStore.entity.BrandEntity;
import com.smartphone.phoneStore.entity.PhoneSpecsEntity;
import com.smartphone.phoneStore.feign.MobileSpecsClient;
import com.smartphone.phoneStore.repository.BrandRepository;
import com.smartphone.phoneStore.repository.PhoneSpecsRepository;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.BrandDTO;
import org.openapitools.model.ModelDTO;
import org.openapitools.model.PhoneImageDTO;
import org.openapitools.model.PhoneSpecsResponseDTO;
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

    public List<ModelDTO> getModelsByBrandName(String brandName) {
        return mobileSpecsClient.getModelsByBrandName(brandName);
    }


    public PhoneSpecsResponseDTO getSpecificationsByBrandAndModel(String brandName, String modelName) {
        return mobileSpecsClient.getSpecificationsByBrandAndModel(brandName, modelName);
    }

    public List<PhoneImageDTO> getPhoneImagesByCustomId(int customId) {
        return mobileSpecsClient.getPhoneImagesByCustomId(customId);
    }

}