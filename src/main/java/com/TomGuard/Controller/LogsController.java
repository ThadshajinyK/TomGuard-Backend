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

    @GetMapping("/{logsId}")
    public Optional<LogsEntity> findById(@PathVariable("logsId") Long logsId){
        return logsService.findById(logsId);
    }

    @PostMapping("/add")
    public LogsEntity saveLogs(@RequestBody LogsEntity logsEntity){
        return logsService.saveLog(logsEntity);
    }

    @PutMapping("/update")
    public LogsEntity updateLogs(@RequestBody LogsEntity logsEntity){
        return logsService.saveLog(logsEntity);
    }

    @DeleteMapping("{logsId}")
    public void deleteLogs(@PathVariable("logsId") Long logsId){
        logsService.deleteLog(logsId);
    }
}

//cdwn