package com.TomGuard.Repository;

import com.TomGuard.Entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends JpaRepository<ApplicationEntity, String> {
}
