package com.TomGuard.Controller;

import com.TomGuard.Entity.ClientEntity;
import com.TomGuard.Entity.Clientpdf;
import com.TomGuard.Entity.ServerEntity;
import com.TomGuard.Entity.ServerPdf;
import com.TomGuard.Service.ClientService;
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
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("all")
    public List<ClientEntity> findAllClients(){
        return clientService.findAllClient();
    }

    @GetMapping("/{id}")
    public Optional<ClientEntity> findById(@PathVariable("id")Long id){
        return clientService.findById(id);
    }

    @PostMapping("/add")
    public ClientEntity saveClient(@RequestBody ClientEntity clientEntity){
        return clientService.saveClient(clientEntity);
    }

    @PutMapping("/update")
    public void updateClient(@RequestBody ClientEntity clientEntity){
         clientService.updateClient(clientEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable("id") Long id)
    {
        clientService.deleteById(id);
    }

    @GetMapping("/clientpdf")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<ClientEntity> clientEntityList = clientService.findAllClient();




        Clientpdf clientpdf = new Clientpdf();
        clientpdf.setclientlist(clientEntityList);
        clientpdf.generate(response);


    }
}
