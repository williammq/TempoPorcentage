package com.pruebaTecnica.tenpo.repository;

import com.pruebaTecnica.tenpo.model.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
}
