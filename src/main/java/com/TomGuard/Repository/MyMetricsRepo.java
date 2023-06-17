package com.TomGuard.Repository;

import com.TomGuard.Entity.MyMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface MyMetricsRepo extends JpaRepository<MyMetrics, Long> {
}
