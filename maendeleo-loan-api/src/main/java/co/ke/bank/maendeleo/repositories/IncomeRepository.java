package co.ke.bank.maendeleo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {

	public List<Income> findByInstitutionId(Long id);

}
