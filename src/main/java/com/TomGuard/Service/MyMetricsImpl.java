package com.TomGuard.Service;

import com.TomGuard.Entity.MyMetrics;
import com.TomGuard.Repository.MyMetricsRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MyMetricsImpl implements MyMetricsService {

    private final MyMetricsRepo myMetricsRepo;

    public MyMetricsImpl(MyMetricsRepo myMetricsRepo) {
        this.myMetricsRepo = myMetricsRepo;
    }

    @Override
    public List<MyMetrics> findAllMetrics() {
        return myMetricsRepo.findAll();
    }

    @Override
    public Optional<MyMetrics> findById(Long id) {
        return myMetricsRepo.findById(id);
    }

    @Override
    public MyMetrics saveMetrics(MyMetrics myMetrics) {
        myMetrics.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return myMetricsRepo.save(myMetrics);
    }

    @Override
    public MyMetrics updateMetrics(MyMetrics myMetrics) {
        return myMetricsRepo.save(myMetrics);
    }

    @Override
    public void deleteMetrics(Long id) {
        myMetricsRepo.deleteById(id);
    }
}
