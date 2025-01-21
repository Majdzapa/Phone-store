package com.smartphone.phoneStore.config;

import com.smartphone.phoneStore.entity.SmartPhoneEntity;
import com.smartphone.phoneStore.repository.SmartPhoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(SmartPhoneRepository repository) {

        SmartPhoneEntity phone1 =  SmartPhoneEntity.builder()
                .image("".getBytes())
                .os("iOS")
                .reference("12345")
                .model("iPhone 13")
                .brand("Apple")
                .description("")
                .build();

        SmartPhoneEntity phone2 =  SmartPhoneEntity.builder()
                .image("".getBytes())
                .os("Android")
                .reference("67890")
                .model("Galaxy S21")
                .brand("Samsung")
                .description("")
                .build();

        return args -> {
            repository.save(phone1 );
            repository.save(phone2);
        };
    }
}