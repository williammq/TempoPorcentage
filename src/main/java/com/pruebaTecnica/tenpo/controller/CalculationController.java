package com.pruebaTecnica.tenpo.controller;

import com.pruebaTecnica.tenpo.model.entity.HistoryEntity;
import com.pruebaTecnica.tenpo.service.HistoryService;
import com.pruebaTecnica.tenpo.service.CalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculationController {

    private final CalculationService calculationService;
    private final HistoryService historyService;

    public CalculationController(CalculationService calculationService, HistoryService historyService) {
        this.calculationService = calculationService;
        this.historyService = historyService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> calculate(@RequestParam double num1, @RequestParam double num2) {
        try {
            double result = calculationService.calculateWithPercentage(num1, num2);
            historyService.saveHistory("/calculate", "num1=" + num1 + "&num2=" + num2, String.valueOf(result), false);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            historyService.saveHistory("/calculate", "num1=" + num1 + "&num2=" + num2, e.getMessage(), true);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<HistoryEntity>> getHistory() {
        return ResponseEntity.ok(historyService.getAllHistory());
    }
}

