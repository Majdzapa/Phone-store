package com.smartphone.phoneStore.ecxeption;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ErrorObject {

    private final String title;
    private final String description;
    private final LocalDateTime dateTime =  LocalDateTime.now();

}