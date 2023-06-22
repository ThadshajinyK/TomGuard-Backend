package com.TomGuard.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "alerts")
public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String alertType;
    private String severityLevel;
    private String description;
    private LocalDateTime timeOfOccurance;
    private long checkedMetricId;
}
