package co.ke.bank.maendeleo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

	public List<LoanApplication> findByAccountId(Long id);

}
