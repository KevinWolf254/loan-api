package co.ke.bank.maendeleo.services;

import java.util.List;

import co.ke.bank.maendeleo.entities.OtherBankLoan;
import co.ke.bank.maendeleo.exceptions.AccountNotFoundException;

public interface OtherBankLoanService {

	public List<OtherBankLoan> read(int identityNo) throws AccountNotFoundException;

}
