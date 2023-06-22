package com.TomGuard.Service;

import com.TomGuard.Entity.AlertEntity;
import com.TomGuard.Entity.MetricsEntity;
import com.TomGuard.Model.Alert;
import com.TomGuard.Repository.AlertRepository;
import com.TomGuard.Repository.MetricsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertServicesImpl implements AlertServices {
    private final AlertRepository alertRepository;

    private final MetricsRepository metricsRepository;

    public AlertServicesImpl(AlertRepository alertRepository, MetricsRepository metricsRepository) {
        this.alertRepository = alertRepository;
        this.metricsRepository = metricsRepository;

    }

    //Alert for CPU usage
    @Override
    public void cpuUsageAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double cpuUsageValue = metricsEntity.getCpuUsage();

            AlertEntity alert = new AlertEntity();
            if (cpuUsageValue >= 95) {
                alert.setAlertType("Very high CPU usage found");
                alert.setSeverityLevel("High");
                alert.setDescription("CPU usage is " + cpuUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);

            } else if (cpuUsageValue >= 90) {

                alert.setAlertType("High CPU usage found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("CPU usage is " + cpuUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);

            } else if (cpuUsageValue >= 80) {

                alert.setAlertType("Significant amount of CPU usage found");
                alert.setSeverityLevel("Low");
                alert.setDescription("CPU usage is " + cpuUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);

            }
        }
    }

    //Alert for memory usage
    @Override
    public void memoryUsageAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double memoryUsageValue = metricsEntity.getMemoryUsage();
            AlertEntity alert = new AlertEntity();
            if (memoryUsageValue >= 95) {

                alert.setAlertType("Very high memory usage found");
                alert.setSeverityLevel("High");
                alert.setDescription("Memory usage is " + memoryUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);

            } else if (memoryUsageValue >= 90) {

                alert.setAlertType("High memory usage found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Memory usage is " + memoryUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);

            } else if (memoryUsageValue >= 80) {

                alert.setAlertType("Significant amount of memory usage found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Memory usage is " + memoryUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            }

        }
    }

    //Alert for disk usage
    @Override
    public void diskUsageAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double diskUsageValue = metricsEntity.getDiskUsage();
            AlertEntity alert = new AlertEntity();
            if (diskUsageValue >= 95) {

                alert.setAlertType("Very high disk usage found");
                alert.setSeverityLevel("High");
                alert.setDescription("Disk usage is " + diskUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);

            } else if (diskUsageValue >= 90) {

                alert.setAlertType("High disk usage found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Disk usage is " + diskUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (diskUsageValue >= 80) {

                alert.setAlertType("Significant amount of disk usage found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Disk usage is " + diskUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);

            }
        }
    }

    //Alert for thread usage
    @Override
    public void threadUsageAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double threadUsageValue = metricsEntity.getThreadUsage();
            AlertEntity alert = new AlertEntity();
            if (threadUsageValue >= 95) {

                alert.setAlertType("Very high thread usage found");
                alert.setSeverityLevel("High");
                alert.setDescription("Thread usage is " + threadUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (threadUsageValue >= 90) {

                alert.setAlertType("High thread usage found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Thread usage is " + threadUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (threadUsageValue >= 80) {

                alert.setAlertType("Significant amount of thread usage found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Thread usage is " + threadUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            }
        }
    }

    //Alert for number of sessions
    @Override
    public void numberOfSessionsUsageAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double numberOfSessionsUsageValue = metricsEntity.getNumberOfSessions();
            AlertEntity alert = new AlertEntity();
            if (numberOfSessionsUsageValue >= 95) {

                alert.setAlertType("Very high number of sessions usage found");
                alert.setSeverityLevel("High");
                alert.setDescription("Number of sessions usage is " + numberOfSessionsUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (numberOfSessionsUsageValue >= 90) {
                alert.setAlertType("High number of session usage found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Number of session  usage is " + numberOfSessionsUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (numberOfSessionsUsageValue >= 80) {

                alert.setAlertType("Significant amount of number of session usage found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Number of session usage is " + numberOfSessionsUsageValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            }
        }
    }

    //Alert for response time
    @Override
    public void responseTimeAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double responseTimeValue = metricsEntity.getResponseTime();
            AlertEntity alert = new AlertEntity();
            if (responseTimeValue >= 1000) {

                alert.setAlertType("Very high response time found");
                alert.setSeverityLevel("High");
                alert.setDescription("Response time is " + responseTimeValue + "ms");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (responseTimeValue >= 500) {

                alert.setAlertType("High response time found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Response time is " + responseTimeValue + "ms");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (responseTimeValue >= 200) {

                alert.setAlertType("Significant amount of response time found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Response time is " + responseTimeValue + "ms");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            }
        }
    }

    //Alert for request time
    @Override
    public void requestTimeAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double requestTimeValue = metricsEntity.getRequestTime();
            AlertEntity alert = new AlertEntity();
            if (requestTimeValue >= 1000) {

                alert.setAlertType("Very high request time found");
                alert.setSeverityLevel("High");
                alert.setDescription("Request time is " + requestTimeValue + "ms");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (requestTimeValue >= 500) {

                alert.setAlertType("High request time found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Request time is " + requestTimeValue + "ms");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (requestTimeValue >= 200) {

                alert.setAlertType("Significant amount of request time found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Request time is " + requestTimeValue + "ms");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            }
        }
    }

    //Alert for uptimeAlert
    @Override
    public void uptimeAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double upTimeValue = metricsEntity.getUptime();
            AlertEntity alert = new AlertEntity();
            if (upTimeValue <= 95 && upTimeValue >= 90) {

                alert.setAlertType("Good uptime found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Uptime is " + upTimeValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (upTimeValue < 90 && upTimeValue >= 80) {

                alert.setAlertType("Low uptime found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Uptime is " + upTimeValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (upTimeValue < 80) {

                alert.setAlertType("Very low uptime found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Uptime is " + upTimeValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            }
        }
    }

    //Alert for availability alert
    @Override
    public void availabilityAlert() {
        List<MetricsEntity> metricsEntities = metricsRepository.findAll();
        for (MetricsEntity metricsEntity : metricsEntities) {
            double availabilityValue = metricsEntity.getAvailability();
            AlertEntity alert = new AlertEntity();
            if (availabilityValue <= 95 && availabilityValue >= 90) {

                alert.setAlertType("Good availability found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Availability is " + availabilityValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (availabilityValue < 90 && availabilityValue >= 80) {

                alert.setAlertType("Low availability found");
                alert.setSeverityLevel("Medium");
                alert.setDescription("Availability is " + availabilityValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            } else if (availabilityValue < 80) {

                alert.setAlertType("Very low availability found");
                alert.setSeverityLevel("Low");
                alert.setDescription("Availability is " + availabilityValue + "%");
                alert.setTimeOfOccurance(LocalDateTime.now());
                alert.setCheckedMetricId(metricsEntity.getId());
                alertRepository.save(alert);
            }
        }
    }

    @Override
    public void allAlerts() {
        AlertEntity alert= new AlertEntity();
        boolean isDuplicate = alertRepository.existsByCheckedMetricId(alert.getCheckedMetricId());

        if(!isDuplicate){
            cpuUsageAlert();
            memoryUsageAlert();
            threadUsageAlert();
            diskUsageAlert();
            numberOfSessionsUsageAlert();
            responseTimeAlert();
            requestTimeAlert();
            uptimeAlert();
            availabilityAlert();
        }
    }

    @Override
    public List<Alert> getAllAlerts() {
        List<AlertEntity> alertEntities = alertRepository.findAll();
        List<Alert> alerts = alertEntities.stream().map(emp -> new Alert(emp.getId(),emp.getAlertType(),emp.getSeverityLevel(),emp.getDescription(),emp.getTimeOfOccurance())).collect(Collectors.toList());
        return alerts;
    }

    @Override
    public boolean deleteAlert(Long id) {
        AlertEntity alert = alertRepository.findById(id).get();
        alertRepository.delete(alert);
        return true;
    }
}






















































































