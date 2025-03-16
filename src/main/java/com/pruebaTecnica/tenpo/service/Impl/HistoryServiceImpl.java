package com.pruebaTecnica.tenpo.service.Impl;

import com.pruebaTecnica.tenpo.model.entity.HistoryEntity;
import com.pruebaTecnica.tenpo.repository.HistoryRepository;
import com.pruebaTecnica.tenpo.service.HistoryService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Async
    @Override
    public void saveHistory(String endpoint, String params, String response, boolean isError) {
        HistoryEntity history = new HistoryEntity();
        history.setEndpoint(endpoint);
        history.setParams(params);
        history.setResponse(response);
        history.setError(isError);
        history.setTimestamp(LocalDateTime.now());
        historyRepository.save(history);
    }

    @Override
    public List<HistoryEntity> getAllHistory() {
        return historyRepository.findAll();
    }
}
