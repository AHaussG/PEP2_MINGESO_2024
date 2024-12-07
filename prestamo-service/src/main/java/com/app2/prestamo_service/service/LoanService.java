package com.app2.prestamo_service.service;

import com.app2.prestamo_service.entity.Loan;
import com.app2.prestamo_service.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(int id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan updateLoan(int id, Loan loanDetails) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            loan.setTipoPrestamo(loanDetails.getTipoPrestamo());
            loan.setMonto(loanDetails.getMonto());
            loan.setPlazo(loanDetails.getPlazo());
            loan.setTasaInteres(loanDetails.getTasaInteres());
            loan.setValorPropiedad(loanDetails.getValorPropiedad());
            loan.setEstado(loanDetails.getEstado());
            loan.setComprobanteIngreso(loanDetails.isComprobanteIngreso());
            loan.setCertificadoAvaluo(loanDetails.isCertificadoAvaluo());
            return loanRepository.save(loan);
        }
        return null;
    }

    public Loan markComprobanteAsDelivered(int id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            loan.setComprobanteIngreso(true);
            return loanRepository.save(loan);
        }
        return null;
    }

    public Loan markCertificadoAsDelivered(int id) {
        Loan loan = loanRepository.findById(id).orElse(null);
        if (loan != null) {
            loan.setCertificadoAvaluo(true);
            return loanRepository.save(loan);
        }
        return null;
    }

    public void deleteLoan(int id) {
        loanRepository.deleteById(id);
    }
}
