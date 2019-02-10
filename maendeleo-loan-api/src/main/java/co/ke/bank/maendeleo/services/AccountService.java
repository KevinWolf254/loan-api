package co.ke.bank.maendeleo.services;

import co.ke.bank.maendeleo.entities.Account;
import co.ke.bank.maendeleo.exceptions.AccountNotFoundException;

public interface AccountService {

	public Account read(int identityNo) throws AccountNotFoundException;

}
