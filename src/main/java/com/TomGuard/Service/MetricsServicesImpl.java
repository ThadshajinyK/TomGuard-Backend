package com.TomGuard.Service;
import com.TomGuard.Repository.MetricsRepository;
import org.springframework.stereotype.Service;

@Service
public class MetricsServicesImpl implements MetricsServices {
    private MetricsRepository metricsRepository;

    public MetricsServicesImpl(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }
}
