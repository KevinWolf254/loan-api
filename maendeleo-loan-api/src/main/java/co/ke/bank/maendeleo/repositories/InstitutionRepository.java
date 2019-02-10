package co.ke.bank.maendeleo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
