package com.TomGuard.Controller;

import com.TomGuard.Entity.ServerEntity;
import com.TomGuard.Entity.ServerPdf;
import com.TomGuard.Repository.ServerRepo;
import com.TomGuard.Service.ServerService;
import com.lowagie.text.DocumentException;
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

    @GetMapping("/{id}")
    public Optional<ServerEntity> findById(@PathVariable("id")Long id){
        return serverService.findById(id);
    }

    @PostMapping("/add")
    public ServerEntity saveServer(@RequestBody ServerEntity serverEntity){
        return serverService.saveServer(serverEntity);
    }

    @PutMapping("/update")
    public ServerEntity updateServer(@RequestBody ServerEntity serverEntity){
        return serverService.updateServer(serverEntity);
    }


    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable("id") Long id)
    {
        serverService.deleteServer(id);
    }

    @GetMapping("/serverpdf")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        List<ServerEntity> serverEntityList = serverService.findAllServers();


        ServerPdf serverPdf = new ServerPdf();
        serverPdf.setserverlist(serverEntityList);
        serverPdf.generate(response);



    }
}
