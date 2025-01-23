package com.smartphone.phoneStore.feign;

import feign.Headers;
import org.openapitools.model.BrandDTO;
import org.openapitools.model.PhoneSpecsResponseDTO;
import  org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mobileSpecsClient", url = "https://mobile-phone-specs-database.p.rapidapi.com")
public interface MobileSpecsClient {

    @GetMapping("/gsm/all-brands")
    @Headers({
            "x-rapidapi-key: 4c9a9eb06amsh18a6a44a3915cfcp1c27edjsnd3d7c7f4108d",
            "x-rapidapi-host: mobile-phone-specs-database.p.rapidapi.com"
    })
    List<BrandDTO> getAllBrands();

    @GetMapping("/gsm/get-specifications-by-phone-custom-id/{customId}")
    @Headers({
            "x-rapidapi-key: 4c9a9eb06amsh18a6a44a3915cfcp1c27edjsnd3d7c7f4108d",
            "x-rapidapi-host: mobile-phone-specs-database.p.rapidapi.com"
    })
    PhoneSpecsResponseDTO getPhoneSpecsByCustomId(@PathVariable("customId") int customId);
}
