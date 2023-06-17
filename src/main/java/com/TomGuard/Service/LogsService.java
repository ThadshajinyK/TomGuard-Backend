package com.TomGuard.Service;



import com.TomGuard.Entity.LogsEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface LogsService {
    List<LogsEntity> findAllLogs();
    Optional<LogsEntity> findById(Long logsId);
    LogsEntity saveLog(LogsEntity logsEntity);
    LogsEntity updateLog(LogsEntity logsEntity);
    void deleteLog(Long logsId);

}
