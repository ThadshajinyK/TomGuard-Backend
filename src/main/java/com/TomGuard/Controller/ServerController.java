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
}
