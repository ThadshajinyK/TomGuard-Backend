package com.TomGuard.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private long id;
    private String alertType;
    private String severityLevel;
    private String description;
    private LocalDateTime timeOfOccurance;
}
