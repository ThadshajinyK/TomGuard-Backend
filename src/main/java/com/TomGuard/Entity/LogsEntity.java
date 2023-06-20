package com.TomGuard.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="logs")
public class LogsEntity {
    @Id
    private String timestamp;
    @Column(nullable = true)
    private String logLevel;

    @Column(nullable = true)
    private String loggerName;

    @Column(nullable = true)
    private String threadName;

    @Column(nullable = true)
    private String message;

    public LogsEntity() {

    }

    public LogsEntity(String timestamp, String logLevel, String loggerName, String threadName, String message) {
        this.timestamp=timestamp;
        this.logLevel = logLevel;
        this.loggerName = loggerName;
        this.threadName = threadName;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
