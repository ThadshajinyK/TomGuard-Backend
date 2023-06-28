package com.TomGuard.Controller;


import com.TomGuard.Entity.MyMetrics;
import com.TomGuard.Service.MyMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/metrics")
public class MyMetricController{
    @Autowired
    private final MyMetricsService myMetricsService;

    public MyMetricController(MyMetricsService myMetricsService) {
        this.myMetricsService = myMetricsService;
    }

    @GetMapping("/all")
    public List<MyMetrics> findAllMetrics(){
        return myMetricsService.findAllMetrics();
    }

    @GetMapping("/{id}")
    public Optional<MyMetrics> findById(@PathVariable("id")Long id){
        return myMetricsService.findById(id);
    }

    @PostMapping("/add")
    public MyMetrics saveMetrics(@RequestBody MyMetrics myMetrics){
        return myMetricsService.saveMetrics(myMetrics);
    }

    @PutMapping("/update")
    public MyMetrics updateMetrics(@RequestBody MyMetrics myMetrics){
        return myMetricsService.updateMetrics(myMetrics);
    }

    @DeleteMapping("{id}")
    public void deleteMetrics(@PathVariable("id") Long id){
        myMetricsService.deleteMetrics(id);
    }

    @DeleteMapping("/dltAll")
    public void deleteMetricsAll()
    {
        myMetricsService.deleteAllMetrics();
    }
}




