package com.pruebaTecnica.tenpo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CalculationResponse {
    private double result;
    private LocalDateTime timestamp;
}