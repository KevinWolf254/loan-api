package co.ke.bank.maendeleo.services.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.OtherBankLoan;

public interface OtherBankLoanRepository extends JpaRepository<OtherBankLoan, Long> {

	public List<OtherBankLoan> findByAccountId(Long id);
}
