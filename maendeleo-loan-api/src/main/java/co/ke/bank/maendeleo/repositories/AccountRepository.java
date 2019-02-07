package co.ke.bank.maendeleo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public Optional<Account> findByMemberId(Long memberIdNo);

}
