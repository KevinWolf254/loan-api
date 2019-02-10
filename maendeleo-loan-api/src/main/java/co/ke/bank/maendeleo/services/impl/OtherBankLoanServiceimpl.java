package co.ke.bank.maendeleo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.entities.Account;
import co.ke.bank.maendeleo.entities.OtherBankLoan;
import co.ke.bank.maendeleo.exceptions.AccountNotFoundException;
import co.ke.bank.maendeleo.services.AccountService;
import co.ke.bank.maendeleo.services.OtherBankLoanService;

@Service
public class OtherBankLoanServiceimpl implements OtherBankLoanService {

	@Autowired
	private OtherBankLoanRepository repository;
	@Autowired
	private AccountService accountService;
	
	
	@Override
	public List<OtherBankLoan> read(final int identityNo) throws AccountNotFoundException {
		final Account account = accountService.read(identityNo);
		return repository.findByAccountId(account.getId());
	}

}
