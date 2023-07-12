package com.TomGuard.Service;

import com.TomGuard.Entity.AlertEntity;
import com.TomGuard.Entity.MyMetrics;
import com.TomGuard.Entity.PreventDuplicateAlerts;
import com.TomGuard.Model.Alert;
import com.TomGuard.Repository.AlertRepository;
import com.TomGuard.Repository.MyMetricsRepo;
import com.TomGuard.Repository.PreventDuplicateAlertsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AlertServicesImpl implements AlertServices {
    private final AlertRepository alertRepository;

    private final MyMetricsRepo myMetricsRepo;

    private final PreventDuplicateAlertsRepository preventDuplicateAlertsRepository;

    public AlertServicesImpl(AlertRepository alertRepository, MyMetricsRepo myMetricsRepo, PreventDuplicateAlertsRepository preventDuplicateAlertsRepository) {
        this.alertRepository = alertRepository;
        this.myMetricsRepo = myMetricsRepo;
        this.preventDuplicateAlertsRepository = preventDuplicateAlertsRepository;
    }
    @Override
    public void allAlerts() {
        List<MyMetrics> myMetricsList = myMetricsRepo.findAll();
        for (MyMetrics myMetrics : myMetricsList) {
            boolean alertExists = preventDuplicateAlertsRepository.existsByCheckedMetricId(myMetrics.getId());
            if (!alertExists) {
                double responseTimeValue = myMetrics.getResponseTimeInMillis();
                if (responseTimeValue >= 20) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Very high response time found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Response time is " + responseTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (responseTimeValue >= 15) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("High response time found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Response time is " + responseTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (responseTimeValue >= 10) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Response time can be improved");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Response time is " + responseTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                }

                double memoryUsageValue = myMetrics.getMemoryUsage();
                if (memoryUsageValue >= 100) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Very high memory usage found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Memory usage is " + memoryUsageValue);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (memoryUsageValue >= 90) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("High memory usage found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Memory usage is " + memoryUsageValue);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (memoryUsageValue >= 80) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Memory usage can be improved");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Memory usage is " + memoryUsageValue);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                }

                double threadCount = myMetrics.getThreadCount();
                if (threadCount >= 100) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Very high thread count found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Thread count is "+threadCount);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (threadCount >= 80) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("High thread count found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Thread count is " + threadCount);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (threadCount >= 60) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Thread count can be improved");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Thread count is " + threadCount);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                }

                double requestTimeValue = myMetrics.getRequestTimeInMillis();
                if (requestTimeValue >= 30000) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Very high request time found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Request time is " + requestTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (requestTimeValue >= 20000) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("High request time found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Request time is " + requestTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (requestTimeValue >= 15000) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Response time can be improved");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Request time is " + requestTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                }

                double upTimeValue = myMetrics.getUptimeInMillis();
                if (upTimeValue >= 15000 && upTimeValue < 20000) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Very low uptime found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Uptime is " + upTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (upTimeValue >= 20000 && upTimeValue < 30000) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Low uptime found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Uptime is " + upTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                } else if (upTimeValue >= 30000) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Uptime can be improved");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Uptime is " + upTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                }

                String availabilityValue = myMetrics.getAvailability();
                if (Objects.equals(availabilityValue, "offline")) {
                    AlertEntity alert = new AlertEntity();
                    PreventDuplicateAlerts preventDuplicateAlerts = new PreventDuplicateAlerts();
                    alert.setAlertType("Server is offline");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Availability: " + availabilityValue);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    preventDuplicateAlerts.setCheckedMetricId(myMetrics.getId());
                    preventDuplicateAlertsRepository.save(preventDuplicateAlerts);
                    alertRepository.save(alert);
                }
            }
        }
    }
    @Override
    public List<Alert> getAllAlerts () {
        List<AlertEntity> alertEntities = alertRepository.findAll();
        List<Alert> alerts = alertEntities.stream().map(emp -> new Alert(emp.getId(), emp.getAlertType(), emp.getSeverityLevel(), emp.getDescription(), emp.getTimeOfOccurance())).collect(Collectors.toList());
        return alerts;
    }

    @Override
    public boolean deleteAlert (Long id){
        AlertEntity alert = alertRepository.findById(id).get();
        alertRepository.delete(alert);
        return true;
    }

    @Override
    public void deleteAll() {
        alertRepository.deleteAll();
    }
}
