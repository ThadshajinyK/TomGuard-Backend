package com.TomGuard.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "demometrics")
public class MetricsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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