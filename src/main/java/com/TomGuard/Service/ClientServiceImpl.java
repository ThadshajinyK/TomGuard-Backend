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
    public void updateClient(ClientEntity clientEntity) {
        Optional<ClientEntity> existingClient = clientRepo.findById(clientEntity.getId());
        if(existingClient.isPresent())
        {
            ClientEntity updatedClient = existingClient.get();
            updatedClient.setCompanyName(clientEntity.getCompanyName());
            updatedClient.setBusinessType(clientEntity.getBusinessType());
            updatedClient.setContactPerson(clientEntity.getContactPerson());
            updatedClient.setExpectedFeatures(clientEntity.getExpectedFeatures());
            updatedClient.setProjectScope(clientEntity.getProjectScope());
            updatedClient.setProjectName(clientEntity.getProjectName());
            updatedClient.setEmailAddress(clientEntity.getEmailAddress());
            updatedClient.setPhoneNumber(clientEntity.getPhoneNumber());
            updatedClient.setTargetAudience(clientEntity.getTargetAudience());
            updatedClient.setProjectType(clientEntity.getProjectType());

        }
    }

    @Override
    public void deleteById(Long id) {
        clientRepo.deleteById(id);
    }
}
