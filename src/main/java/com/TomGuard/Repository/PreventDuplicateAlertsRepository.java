package com.TomGuard.Repository;

import com.TomGuard.Entity.PreventDuplicateAlerts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreventDuplicateAlertsRepository extends JpaRepository<PreventDuplicateAlerts,Long> {
    boolean existsByCheckedMetricId(Long metricId);
}
