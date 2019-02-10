package co.ke.bank.maendeleo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.entities.Account;
import co.ke.bank.maendeleo.exceptions.AccountNotFoundException;
import co.ke.bank.maendeleo.repositories.AccountRepository;
import co.ke.bank.maendeleo.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;
	
	@Override
	public Account read(int identityNo) throws AccountNotFoundException {
		final Optional<Account> account = repository.findByMemberIdentityNo(identityNo);
		if(!account.isPresent())
			throw new AccountNotFoundException();
		return account.get();
	}

}
