package com.TomGuard.Controller;

import com.TomGuard.Entity.ApplicationEntity;
import com.TomGuard.Entity.Apppdf;
import com.TomGuard.Service.ApplicationService;
import com.lowagie.text.DocumentException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/apppdf")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<ApplicationEntity> applicationEntityList = applicationService.findAllApps();


        Apppdf apppdf =new Apppdf();
        apppdf.setapplist(applicationEntityList);
        apppdf.generate(response);



    }

    @PersistenceUnit
    private EntityManagerFactory emfy;

    @GetMapping("/appcount")
    public long getServerCount() {
        EntityManager em = emfy.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(a) FROM ApplicationEntity a");
            return (long) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
