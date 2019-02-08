package co.ke.bank.maendeleo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

	public Optional<Bank> findByName(String bankName);

}
