package co.ke.bank.maendeleo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.LoanAmount;

public interface LoanAmountRepository extends JpaRepository<LoanAmount, Long> {

}
