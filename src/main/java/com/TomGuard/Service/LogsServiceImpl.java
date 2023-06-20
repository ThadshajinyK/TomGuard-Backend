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
    public Optional<LogsEntity> findById(String timestamp) {
        return logsRepo.findById(timestamp);
    }

    @Override
    public void saveLog(LogsEntity logsEntity) {
        Optional<LogsEntity> existingLog=logsRepo.findById(logsEntity.getTimestamp());
        if(existingLog.isPresent()){
            LogsEntity updatedLog= existingLog.get();
            if(logsEntity.getMessage()!=updatedLog.getMessage()){
                logsRepo.save(logsEntity);
            }
             //do nothing: do not save or update
        }
    }

    @Override
    public LogsEntity updateLog(LogsEntity logsEntity) {
        return logsRepo.save(logsEntity);
    }

    @Override
    public void deleteLog(String timestamp) {
        logsRepo.deleteById(timestamp);
    }
}
