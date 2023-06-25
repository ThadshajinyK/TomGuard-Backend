package com.TomGuard.Service;

import com.TomGuard.Entity.MyMetrics;
import com.TomGuard.Entity.ServerEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface MyMetricsService {
    List<MyMetrics> findAllMetrics();
    Optional<MyMetrics> findById(Long id);
    MyMetrics saveMetrics(MyMetrics myMetrics);
    MyMetrics updateMetrics(MyMetrics myMetrics);
    void deleteMetrics(Long id);
    void deleteAllMetrics();
}
