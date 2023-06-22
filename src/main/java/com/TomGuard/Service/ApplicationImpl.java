package com.TomGuard.Service;

import com.TomGuard.Entity.ApplicationEntity;
import com.TomGuard.Repository.ApplicationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationImpl implements ApplicationService{

    private final ApplicationRepo applicationRepo;

    public ApplicationImpl(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    @Override
    public List<ApplicationEntity> findAllApps() {
        return applicationRepo.findAll();
    }

    @Override
    public Optional<ApplicationEntity> findById(String applicationName) {
        return applicationRepo.findById(applicationName);
    }

    @Override
    public ApplicationEntity saveApp(ApplicationEntity applicationEntity) {
        Optional<ApplicationEntity> existingApp = applicationRepo.findById(applicationEntity.getApplicationName());
        if(existingApp.isPresent()){
            ApplicationEntity updatedApp = existingApp.get();
            updatedApp.setPath(applicationEntity.getPath());
            updatedApp.setAppType(applicationEntity.getAppType());
            updatedApp.setClientName(applicationEntity.getClientName());
            updatedApp.setState(applicationEntity.getState());
            return applicationRepo.save(updatedApp);
        }else{
            return applicationRepo.save(applicationEntity);
        }
    }

    @Override
    public ApplicationEntity updateApp(ApplicationEntity applicationEntity) {
        return applicationRepo.save(applicationEntity);
    }

    @Override
    public void deleteById(String applicationName) {
        applicationRepo.deleteById(applicationName);
    }
}
