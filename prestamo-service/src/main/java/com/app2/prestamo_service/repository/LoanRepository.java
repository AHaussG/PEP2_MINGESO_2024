package com.app2.prestamo_service.repository;

import com.app2.prestamo_service.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    // Métodos personalizados para búsqueda:
    // List<Loan> findByUsuarioId(int usuarioId);
}
