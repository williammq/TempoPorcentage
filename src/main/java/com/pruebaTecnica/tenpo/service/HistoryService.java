package com.pruebaTecnica.tenpo.service;

import com.pruebaTecnica.tenpo.model.entity.HistoryEntity;

import java.util.List;

public interface HistoryService {
    void saveHistory(String endpoint, String params, String response, boolean isError);
    List<HistoryEntity> getAllHistory();
}
