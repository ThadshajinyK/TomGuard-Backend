package com.TomGuard.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metrics {
    private long id;
    private double cpuUsage ;
    private double memoryUsage ;
    private double diskUsage ;
    private double threadUsage ;
    private double numberOfSessions ;
    private double responseTime ;
    private double requestTime ;
    private double uptime ;
    private double availability ;
}
