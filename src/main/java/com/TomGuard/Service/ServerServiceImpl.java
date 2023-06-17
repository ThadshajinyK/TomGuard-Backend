package com.TomGuard.Service;

import com.TomGuard.Entity.ServerEntity;
import com.TomGuard.Repository.ServerRepo;

import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServerServiceImpl implements ServerService{

    private final ServerRepo serverRepo;

    public ServerServiceImpl(ServerRepo serverRepo) {
        this.serverRepo = serverRepo;
    }

    @Override
    public List<ServerEntity> findAllServers() {
        return serverRepo.findAll();
    }

    @Override
    public Optional<ServerEntity> findById(Long id) {
        return serverRepo.findById(id);
    }

    @Override
    public ServerEntity saveServer(ServerEntity server) {
        server.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return serverRepo.save(server);
    }

    @Override
    public ServerEntity updateServer(ServerEntity server) {
        return serverRepo.save(server);
    }

    @Override
    public void deleteServer(Long id) {
        serverRepo.deleteById(id);
       // updateIdsAfterDeletion();
    }

    /*public void updateIdsAfterDeletion(){
        List<ServerEntity> remainingEntities = serverRepo.findAll(Sort.by("id"));
        int newId = 1;
        for(ServerEntity entity : remainingEntities){
            entity.setId((long) newId++);
            serverRepo.save(entity);
        }
    }*/
}
