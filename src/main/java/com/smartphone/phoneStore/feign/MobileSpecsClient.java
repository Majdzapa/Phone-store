package com.smartphone.phoneStore.feign;

import feign.Headers;
import org.openapitools.model.BrandDTO;
import org.openapitools.model.ModelDTO;
import org.openapitools.model.PhoneImageDTO;
import org.openapitools.model.PhoneSpecsResponseDTO;
import  org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "mobileSpecsClient", url = "https://mobile-phone-specs-database.p.rapidapi.com")
public interface MobileSpecsClient {

    @GetMapping("/gsm/all-brands")
    List<BrandDTO> getAllBrands(@RequestHeader("x-rapidapi-key") String rapidApiKey, @RequestHeader("x-rapidapi-host") String rapidApiHost);


    @GetMapping("/gsm/get-specifications-by-phone-custom-id/{customId}")
    PhoneSpecsResponseDTO getPhoneSpecsByCustomId(@RequestHeader("x-rapidapi-key") String rapidApiKey,
                                                  @RequestHeader("x-rapidapi-host") String rapidApiHost,
                                                  @PathVariable("customId") int customId);



    @GetMapping("/gsm/get-models-by-brandname/{brandName}")
    List<ModelDTO> getModelsByBrandName(@RequestHeader("x-rapidapi-key") String rapidApiKey,
                                        @RequestHeader("x-rapidapi-host") String rapidApiHost,
                                        @PathVariable("brandName") String brandName);



    @GetMapping("/gsm/get-specifications-by-brandname-modelname/{brandName}/{modelName}")

    PhoneSpecsResponseDTO getSpecificationsByBrandAndModel(
            @RequestHeader("x-rapidapi-key") String rapidApiKey,
            @RequestHeader("x-rapidapi-host") String rapidApiHost,
            @PathVariable("brandName") String brandName,
            @PathVariable("modelName") String modelName
    );


    @GetMapping("/gsm/get-phone-images-links-by-phone-custom-id/{customId}")
    List<PhoneImageDTO> getPhoneImagesByCustomId(@RequestHeader("x-rapidapi-key") String rapidApiKey,
                                                 @RequestHeader("x-rapidapi-host") String rapidApiHost,
                                                 @PathVariable("customId") int customId);


}
