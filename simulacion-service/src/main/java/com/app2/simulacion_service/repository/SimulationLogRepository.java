package com.app2.simulacion_service.repository;

import com.app2.simulacion_service.entity.SimulationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationLogRepository extends JpaRepository<SimulationLog, Integer> {
}
