package co.ke.bank.maendeleo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.bank.maendeleo.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	public Optional<Member> findByIdentityNo(int IdentityNo);
}
