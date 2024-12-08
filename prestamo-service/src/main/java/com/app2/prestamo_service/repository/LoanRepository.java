package com.app2.prestamo_service.repository;

import com.app2.prestamo_service.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findAllByRut(String rut); // Devuelve todos los préstamos asociados al RUT
}
