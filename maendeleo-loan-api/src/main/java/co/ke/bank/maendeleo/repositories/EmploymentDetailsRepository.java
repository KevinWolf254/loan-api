package co.ke.bank.maendeleo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.EmploymentDetails;

public interface EmploymentDetailsRepository extends JpaRepository<EmploymentDetails, Long> {

	public Optional<EmploymentDetails> findByMemberIdentityNo(int identityNo);
}
