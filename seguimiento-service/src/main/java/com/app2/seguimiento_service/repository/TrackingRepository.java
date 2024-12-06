package com.app2.seguimiento_service.repository;

import com.app2.seguimiento_service.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Integer> {
    // Agrega métodos personalizados si es necesario:
    // List<Tracking> findByPrestamoId(int prestamoId);
}
