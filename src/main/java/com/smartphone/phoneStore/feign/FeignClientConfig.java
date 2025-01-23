package com.smartphone.phoneStore.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "phone-spec-database", url = "https://mobile-phone-specs-database.p.rapidapi.com")
public interface FeignClientConfig {

    @GetMapping("/posts/{id}")
    Object getPostById(@PathVariable("id") Long id);
}


