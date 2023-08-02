package com.example.eshopp2.core.utilities.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetail extends ProblemDetails{
    private Map<String ,String> validationError;
}
