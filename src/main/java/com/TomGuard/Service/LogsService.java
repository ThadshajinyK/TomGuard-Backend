package com.TomGuard.Service;



import com.TomGuard.Entity.LogsEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface LogsService {
    List<LogsEntity> findAllLogs();
    Optional<LogsEntity> findById(String timestamp);
    void saveLog(LogsEntity logsEntity);
    LogsEntity updateLog(LogsEntity logsEntity);
    void deleteLog(String timestamp);

}
