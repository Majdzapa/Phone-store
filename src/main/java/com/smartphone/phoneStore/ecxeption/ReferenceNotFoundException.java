package com.smartphone.phoneStore.ecxeption;

public class ReferenceNotFoundException extends RuntimeException {

    public ReferenceNotFoundException(String reference) {
        super("Smartphone with reference " + reference + " not found.");
    }

}
