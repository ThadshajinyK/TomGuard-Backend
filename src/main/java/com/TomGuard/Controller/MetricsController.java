package com.TomGuard.Controller;
import com.TomGuard.Service.MetricsServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class MetricsController {
    private final MetricsServices metricsServices;

    public MetricsController(MetricsServices metricsServices) {
        this.metricsServices = metricsServices;
    }

}



