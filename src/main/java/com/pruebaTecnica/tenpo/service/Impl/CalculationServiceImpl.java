package com.pruebaTecnica.tenpo.service.Impl;

import com.pruebaTecnica.tenpo.service.CalculationService;
import org.springframework.stereotype.Service;

@Service
public class CalculationServiceImpl implements CalculationService {

    private final ExternalPercentageService externalPercentageService;

    public CalculationServiceImpl(ExternalPercentageService externalPercentageService) {
        this.externalPercentageService = externalPercentageService;
    }

    @Override
    public double calculateWithPercentage(double num1, double num2) {
        double sum = num1 + num2;
        double percentage;
        try {
            percentage = externalPercentageService.getPercentage();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener el porcentaje. Servicio y caché fallidos.", e);
        }
        return sum + (sum * percentage / 100);
    }
}
