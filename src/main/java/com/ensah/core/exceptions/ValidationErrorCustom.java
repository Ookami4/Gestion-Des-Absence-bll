package com.ensah.core.exceptions;

public class ValidationErrorCustom extends RuntimeException{
    public ValidationErrorCustom(Class clazz, String searchParams) {
        super(ValidationErrorCustom.generateMessage(clazz.getSimpleName(), searchParams));
    }
    
    
    private static String generateMessage(String entity, String searchParams) {
        return entity + "?" + searchParams;
    }
}
