package com.TomGuard.Controller;

import com.TomGuard.Entity.ClientEntity;
import com.TomGuard.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ClientEntity updateClient(@RequestBody ClientEntity clientEntity){
        return clientService.updateClient(clientEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable("id") Long id)
    {
        clientService.deleteById(id);
    }
}
