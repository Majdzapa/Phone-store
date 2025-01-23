package com.smartphone.phoneStore.controller;


import com.smartphone.phoneStore.service.MobileSpecsService;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.BrandDTO;
import org.openapitools.model.ModelDTO;
import org.openapitools.model.PhoneImageDTO;
import org.openapitools.model.PhoneSpecsResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mobile-specs")
public class MobileSpecsController {

    private final MobileSpecsService mobileSpecsService;


    @GetMapping("/brands")
    public List<BrandDTO> getAllBrands() {
        return mobileSpecsService.fetchAllBrands();
    }

    @GetMapping("/{customId}")
    public PhoneSpecsResponseDTO getPhoneSpecs(@PathVariable int customId) {
        return mobileSpecsService.fetchPhoneSpecsByCustomId(customId);
    }


    @GetMapping("/{brandName}/{modelName}")
    public PhoneSpecsResponseDTO getSpecifications(
            @PathVariable String brandName,
            @PathVariable String modelName
    ) {
        return mobileSpecsService.getSpecificationsByBrandAndModel(brandName, modelName);
    }

    @GetMapping("/linked-image/{customId}")
    public List<PhoneImageDTO> getPhoneImages(@PathVariable int customId) {
        return mobileSpecsService.getPhoneImagesByCustomId(customId);
    }


    @GetMapping("/brand/{brandName}")
    public List<ModelDTO> getPhonesByBrandName(@PathVariable String brandName) {
        return mobileSpecsService.getModelsByBrandName(brandName);
    }
}