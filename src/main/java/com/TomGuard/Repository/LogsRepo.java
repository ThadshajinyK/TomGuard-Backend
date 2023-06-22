package com.TomGuard.Repository;

import com.TomGuard.Entity.LogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface LogsRepo extends JpaRepository<LogsEntity, String> {
}
