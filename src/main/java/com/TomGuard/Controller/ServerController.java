package com.TomGuard.Controller;

import com.TomGuard.Entity.ServerEntity;
import com.TomGuard.Service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
}
