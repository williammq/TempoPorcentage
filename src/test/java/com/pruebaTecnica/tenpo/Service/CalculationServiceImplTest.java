package com.pruebaTecnica.tenpo.Service;

import com.pruebaTecnica.tenpo.service.Impl.CalculationServiceImpl;
import com.pruebaTecnica.tenpo.service.Impl.ExternalPercentageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculationServiceImplTest {

    @Mock
    private ExternalPercentageService externalPercentageService;

    @InjectMocks
    private CalculationServiceImpl calculationService;

    @Test
    void testCalculateWithPercentage() {
        // Arrange
        double num1 = 100;
        double num2 = 50;
        double expectedPercentage = 10.0;
        double expectedResult = 165.0;

        when(externalPercentageService.getPercentage()).thenReturn(expectedPercentage);

        // Act
        double result = calculationService.calculateWithPercentage(num1, num2);

        // Assert
        assertEquals(expectedResult, result);
    }
}