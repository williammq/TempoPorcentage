package com.pruebaTecnica.tenpo.service.Impl;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExternalPercentageService {

    private boolean simulateFailure = false;

    @Cacheable(value = "percentage", unless = "#result == null")
    public double getPercentage() {
        if (simulateFailure) {
            throw new RuntimeException("Servicio externo no disponible");
        }
        return 10.0;
    }

    // Método para simular el fallo
    public void setSimulateFailure(boolean simulateFailure) {
        this.simulateFailure = simulateFailure;
    }
}
