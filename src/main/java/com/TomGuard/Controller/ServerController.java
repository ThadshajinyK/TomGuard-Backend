package com.TomGuard.Controller;

import com.TomGuard.Entity.ServerEntity;
import com.TomGuard.Entity.ServerPdf;
import com.TomGuard.Repository.ServerRepo;
import com.TomGuard.Service.ServerService;
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
@RequestMapping("/server")
public class ServerController {
    @Autowired
    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("all")
    public List<ServerEntity> findAllServers(){
        return serverService.findAllServers();
    }

    @GetMapping("/{hostName}")
    public Optional<ServerEntity> findById(@PathVariable("hostName")String hostName){
        return serverService.findById(hostName);
    }

    @PostMapping("/add")
    public void saveServer(@RequestBody ServerEntity serverEntity){
         serverService.saveServer(serverEntity);
    }

    @PutMapping("/update")
    public ServerEntity updateServer(@RequestBody ServerEntity serverEntity){
        return serverService.updateServer(serverEntity);
    }


    @DeleteMapping("/{hostName}")
    public void deleteServer(@PathVariable("hostName") String hostName)
    {
        serverService.deleteServer(hostName);
    }

    @GetMapping("/serverpdf")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<ServerEntity> serverEntityList = serverService.findAllServers();


        ServerPdf serverPdf = new ServerPdf();
        serverPdf.setserverlist(serverEntityList);
        serverPdf.generate(response);



    }
    @PersistenceUnit
    private EntityManagerFactory emf;
    @GetMapping("/servercount")
    public long getServerCount() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(s) FROM ServerEntity s");
            return (long) query.getSingleResult();
        } finally {
            em.close();
        }
    }


}
