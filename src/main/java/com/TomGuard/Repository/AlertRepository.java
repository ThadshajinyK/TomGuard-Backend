package com.TomGuard.Repository;
import com.TomGuard.Entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlertRepository extends JpaRepository<AlertEntity,Long> {

}
