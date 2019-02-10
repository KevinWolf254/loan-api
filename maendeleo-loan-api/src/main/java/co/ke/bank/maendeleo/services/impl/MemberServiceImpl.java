package co.ke.bank.maendeleo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.entities.Member;
import co.ke.bank.maendeleo.exceptions.MemberNotFoundException;
import co.ke.bank.maendeleo.repositories.MemberRepository;
import co.ke.bank.maendeleo.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository repository;
	
	@Override
	public Member read(int identityNo) throws MemberNotFoundException {
		final Optional<Member> member = repository.findByIdentityNo(identityNo);
		if(!member.isPresent())
			throw new MemberNotFoundException();
		return member.get();
	}
}
