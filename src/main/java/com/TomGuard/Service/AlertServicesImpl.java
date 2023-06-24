package com.TomGuard.Service;

import com.TomGuard.Entity.AlertEntity;
import com.TomGuard.Entity.MyMetrics;
import com.TomGuard.Model.Alert;
import com.TomGuard.Repository.AlertRepository;
import com.TomGuard.Repository.MyMetricsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AlertServicesImpl implements AlertServices {
    private final AlertRepository alertRepository;

    private final MyMetricsRepo myMetricsRepo;

    public AlertServicesImpl(AlertRepository alertRepository, MyMetricsRepo myMetricsRepo) {
        this.alertRepository = alertRepository;
        this.myMetricsRepo = myMetricsRepo;
    }
    @Override
    public void allAlerts() {
        List<MyMetrics> myMetricsList = myMetricsRepo.findAll();
        for (MyMetrics myMetrics : myMetricsList) {
            boolean alertExists = alertRepository.existsByCheckedMetricId(myMetrics.getId());
            if (!alertExists) {
                double responseTimeValue = myMetrics.getResponseTimeInMillis();
                if (responseTimeValue >= 1002) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Very high response time found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Response time is " + responseTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                } else if (responseTimeValue >= 500) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("High response time found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Response time is " + responseTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                } else if (responseTimeValue >= 200) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Significant amount of response time found");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Response time is " + responseTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                }

                double requestTimeValue = myMetrics.getRequestTimeInMillis();
                if (requestTimeValue >= 1000) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Very high request time found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Request time is " + requestTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                } else if (requestTimeValue >= 500) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("High request time found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Request time is " + requestTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                } else if (requestTimeValue >= 200) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Significant amount of request time found");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Request time is " + requestTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                }

                double upTimeValue = myMetrics.getUptimeInMillis();
                if (upTimeValue >= 300000 && upTimeValue < 1800000) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Very low uptime found");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Uptime is " + upTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                } else if (upTimeValue >= 1800000 && upTimeValue < 3600000) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Middle uptime found");
                    alert.setSeverityLevel("Medium");
                    alert.setDescription("Uptime is " + upTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                } else if (upTimeValue >= 3600000) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Good uptime found");
                    alert.setSeverityLevel("Low");
                    alert.setDescription("Uptime is " + upTimeValue + "ms");
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
                    alertRepository.save(alert);
                }

                String availabilityValue = myMetrics.getAvailability();
                if (Objects.equals(availabilityValue, "offline")) {
                    AlertEntity alert = new AlertEntity();
                    alert.setAlertType("Server is offline");
                    alert.setSeverityLevel("High");
                    alert.setDescription("Availability is " + availabilityValue);
                    alert.setTimeOfOccurance(LocalDateTime.now());
                    alert.setCheckedMetricId(myMetrics.getId());
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
    }























































































