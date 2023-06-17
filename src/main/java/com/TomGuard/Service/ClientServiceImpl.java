package com.TomGuard.Service;

import com.TomGuard.Entity.ClientEntity;
import com.TomGuard.Repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<ClientEntity> findAllClient() {
        return clientRepo.findAll();
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        return clientRepo.findById(id);
    }

    @Override
    public ClientEntity saveClient(ClientEntity clientEntity) {
        clientEntity.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return clientRepo.save(clientEntity);
    }

    @Override
    public ClientEntity updateClient(ClientEntity clientEntity) {
        return clientRepo.save(clientEntity);
    }

    @Override
    public void deleteById(Long id) {
        clientRepo.deleteById(id);
    }
}
