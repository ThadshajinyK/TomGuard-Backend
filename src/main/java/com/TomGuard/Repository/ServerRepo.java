package com.TomGuard.Repository;

import com.TomGuard.Entity.ServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServerRepo extends JpaRepository<ServerEntity, Long> {

}
