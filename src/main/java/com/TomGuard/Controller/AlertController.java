package com.TomGuard.Controller;
import com.TomGuard.Model.Alert;
import com.TomGuard.Service.AlertServices;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/")
public class AlertController {
    private final AlertServices alertServices;

    public AlertController(AlertServices alertServices) {
        this.alertServices = alertServices;
    }

    //Get all alerts from database
    @GetMapping("/alerts")
    public List<Alert> getAllAlerts(){
        return alertServices.getAllAlerts();
    }


    //Delete alert by id
    @DeleteMapping("/alerts/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAlert(@PathVariable Long id){
        boolean deleted = false;
        deleted = alertServices.deleteAlert(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }


   @PostConstruct
    public void init() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                alertServices.allAlerts();
            }
        }, 0, 7000); // 7000 milliseconds = 7 seconds
    }
}



