package com.TomGuard.Controller;

import com.TomGuard.Entity.ApplicationEntity;
import com.TomGuard.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apps")
public class ApplicationController {
    @Autowired
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;

    }


    @GetMapping("all")
    public List<ApplicationEntity> findAllApps(){
        return applicationService.findAllApps();
    }

    @GetMapping("/{applicationName}")
    public Optional<ApplicationEntity> findById(@PathVariable("applicationName")String applicationName){
        return applicationService.findById(applicationName);
    }

    @PostMapping("/add")
    public ApplicationEntity saveApp(@RequestBody ApplicationEntity applicationEntity){
        return applicationService.saveApp(applicationEntity);
    }

    @PutMapping("/update")
    public ApplicationEntity updateApp(@RequestBody ApplicationEntity applicationEntity){
        return applicationService.updateApp(applicationEntity);
    }


    @DeleteMapping("/{applicationName}")
    public void deleteApp(@PathVariable("applicationName") String applicationName)
    {
        applicationService.deleteById(applicationName);
    }
}
