package com.app2.simulacion_service.repository;

import com.app2.simulacion_service.entity.SimulationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SimulationLogRepository extends JpaRepository<SimulationLog, Integer> {
}