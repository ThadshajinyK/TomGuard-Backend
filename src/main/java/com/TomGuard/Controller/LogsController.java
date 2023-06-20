package com.TomGuard.Controller;


import com.TomGuard.Entity.LogsEntity;
import com.TomGuard.Service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class LogsController {
    @Autowired
    private final LogsService logsService;

    public LogsController(LogsService logsService) {
        this.logsService = logsService;
    }

    @GetMapping("/all")
    public List<LogsEntity> findAllLogs(){
        return logsService.findAllLogs();
    }

    @GetMapping("/{timestamp}")
    public Optional<LogsEntity> findById(@PathVariable("timestamp") String timestamp){
        return logsService.findById(timestamp);
    }

    @PostMapping("/add")
    public void saveLogs(@RequestBody LogsEntity logsEntity){
         logsService.saveLog(logsEntity);
    }

    @PutMapping("/update")
    public void updateLogs(@RequestBody LogsEntity logsEntity){
         logsService.saveLog(logsEntity);
    }

    @DeleteMapping("{timestamp}")
    public void deleteLogs(@PathVariable("timestamp") String timestamp){
        logsService.deleteLog(timestamp);
    }
}
