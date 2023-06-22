package com.TomGuard.Service;



import com.TomGuard.Entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientEntity> findAllClient();
    Optional<ClientEntity> findById(Long id);
    ClientEntity saveClient(ClientEntity clientEntity);
    void updateClient(ClientEntity clientEntity);
    void deleteById(Long id);
}
