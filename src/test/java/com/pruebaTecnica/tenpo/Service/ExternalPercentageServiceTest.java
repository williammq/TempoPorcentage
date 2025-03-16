package com.pruebaTecnica.tenpo.Service;

import com.pruebaTecnica.tenpo.service.Impl.ExternalPercentageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExternalPercentageServiceTest {

    @Autowired
    private ExternalPercentageService externalPercentageService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testGetPercentageCaching() {
        // Limpiar caché antes de la prueba
        cacheManager.getCache("percentage").clear();

        // Ejecutar el método
        double percentage = externalPercentageService.getPercentage();

        // Verificar que no es null y que se ha almacenado en caché
        assertNotNull(percentage);

        // Comprobar si el valor está en la caché
        Double cachedValue = cacheManager.getCache("percentage").get(SimpleKey.EMPTY, Double.class);
        assertNotNull(cachedValue, "El valor debería haberse guardado en la caché");
    }
}
