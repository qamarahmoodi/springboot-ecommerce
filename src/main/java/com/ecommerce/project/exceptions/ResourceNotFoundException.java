package com.ecommerce.project.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
//    String resource;
    String field;
    String fieldName;
    Long fieldId;


    public ResourceNotFoundException(Long fieldId, String field, String fieldName) {
        super(String.format("%s not found with %s: %d", field, fieldName, fieldId));
        this.fieldId = fieldId;
        this.field = field;
        this.fieldName = fieldName;
    }

}

