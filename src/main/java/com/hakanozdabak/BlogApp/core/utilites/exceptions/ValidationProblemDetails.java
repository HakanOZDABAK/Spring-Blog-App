package com.hakanozdabak.BlogApp.core.utilites.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails {

    private Map<String,String> validationErrors;
}
