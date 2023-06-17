package com.TomGuard.Service;

import com.TomGuard.Entity.ServerEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ServerService {

    List<ServerEntity> findAllServers();
    Optional<ServerEntity> findById(Long id);
    ServerEntity saveServer(ServerEntity server);
    ServerEntity updateServer(ServerEntity server);
    void deleteServer(Long id);

}
