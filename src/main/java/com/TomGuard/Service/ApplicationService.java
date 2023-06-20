package com.TomGuard.Service;



import com.TomGuard.Entity.ApplicationEntity;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<ApplicationEntity> findAllApps();
    Optional<ApplicationEntity> findById(String applicationName);
    ApplicationEntity saveApp(ApplicationEntity applicationEntity);
    ApplicationEntity updateApp(ApplicationEntity applicationEntity);
    void deleteById(String applicationName);
}
