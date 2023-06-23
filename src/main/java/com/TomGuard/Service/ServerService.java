package com.TomGuard.Service;

import com.TomGuard.Entity.ServerEntity;

import java.util.List;
import java.util.Optional;

public interface ServerService {

    List<ServerEntity> findAllServers();
    Optional<ServerEntity> findById(String hostName);

    void saveServer(ServerEntity server);
    ServerEntity updateServer(ServerEntity server);
    void deleteServer(String hostName);

    Long serverCount();
}
