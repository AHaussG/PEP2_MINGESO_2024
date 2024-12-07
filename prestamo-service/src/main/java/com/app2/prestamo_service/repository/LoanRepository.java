package com.app2.prestamo_service.repository;

import com.app2.prestamo_service.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    // Puedes agregar métodos personalizados si los necesitas, aunque JpaRepository cubre lo básico
}
