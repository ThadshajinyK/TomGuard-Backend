package com.TomGuard.Service;

import com.TomGuard.Entity.LogsEntity;
import com.TomGuard.Repository.LogsRepo;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LogsServiceImpl implements LogsService {

    private final LogsRepo logsRepo;

    public LogsServiceImpl(LogsRepo logsRepo) {
        this.logsRepo = logsRepo;
    }

    @Override
    public List<LogsEntity> findAllLogs() {
        return logsRepo.findAll();
    }

    @Override
    public Optional<LogsEntity> findById(Long logsId) {
        return logsRepo.findById(logsId);
    }

    @Override
    public LogsEntity saveLog(LogsEntity logsEntity) {
        return logsRepo.save(logsEntity);
    }

    @Override
    public LogsEntity updateLog(LogsEntity logsEntity) {
        return logsRepo.save(logsEntity);
    }

    @Override
    public void deleteLog(Long logsId) {
        logsRepo.deleteById(logsId);
    }
}
