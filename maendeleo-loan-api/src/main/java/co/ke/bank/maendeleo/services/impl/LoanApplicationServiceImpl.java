package co.ke.bank.maendeleo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.entities.Account;
import co.ke.bank.maendeleo.entities.Bank;
import co.ke.bank.maendeleo.entities.LoanAmount;
import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.entities.OtherBankLoan;
import co.ke.bank.maendeleo.entities.OtherBankLoanAmount;
import co.ke.bank.maendeleo.exceptions.AccountNotFoundException;
import co.ke.bank.maendeleo.exceptions.LoanApplicationNotFoundException;
import co.ke.bank.maendeleo.pojos.ApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;
import co.ke.bank.maendeleo.repositories.AccountRepository;
import co.ke.bank.maendeleo.repositories.BankRepository;
import co.ke.bank.maendeleo.repositories.LoanAmountRepository;
import co.ke.bank.maendeleo.repositories.LoanApplicationRepository;
import co.ke.bank.maendeleo.repositories.OtherLoanAmountRepository;
import co.ke.bank.maendeleo.repositories.OtherLoanRepository;
import co.ke.bank.maendeleo.services.LoanApplicationService;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	@Autowired
	private LoanApplicationRepository repo;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private LoanAmountRepository amountRepo;
	@Autowired
	private OtherLoanAmountRepository amountLoanRepo;
	@Autowired
	private OtherLoanRepository otherLoanRepo;
	@Autowired
	private BankRepository bankRepo;

	@Override
	public Response create(final ApplicationRequest application) throws AccountNotFoundException {		
		// find member's account by member id no
		final Optional<Account> account = accountRepo.findByMemberIdentityNo(application.getIdentityNo());
		if (!account.isPresent())
			throw new AccountNotFoundException();
		
		// save loan amount
		final LoanAmount amount = amountRepo.save(application.getLoan().getAmount());
		
		// get application details and save application
		final LoanApplication _app = application.getLoan();
		_app.setAmount(amount);
		_app.setAccount(account.get());
		repo.save(_app);

		// determine if there are other bank loans
		if (!application.getOtherLoans().isEmpty()) {
			// iterate through the array
			application.getOtherLoans().stream().forEach(loan -> {
				// save details of other loans
				final Optional<Bank> bank = bankRepo.findByName(loan.getBank().getName());
				if (bank.isPresent()) {
						// save loan amount
						final OtherBankLoanAmount additionalAmount = amountLoanRepo.save(loan.getAmount());
						// save loan
						otherLoanRepo.save(new OtherBankLoan(loan.getDateGranted(), loan.getRepaymentPeriod(),
								bank.get(), account.get(), additionalAmount));
				}
			});
		}
		return new Response(201, "Successfully Created");
	}
	
	@Override
	public List<LoanApplication> read(final int memberIdNo) {
		final Optional<Account> account = accountRepo.findByMemberIdentityNo(memberIdNo);
		if (!account.isPresent())
			return new ArrayList<LoanApplication>();

		return repo.findByAccountId(account.get().getId());
	}

	@Override
	public Response update(final LoanApplication request) throws LoanApplicationNotFoundException {
		final Optional<LoanApplication> _loan = repo.findById(request.getId());
		
		if(!_loan.isPresent())
			throw new LoanApplicationNotFoundException();
		
		final LoanApplication loan = _loan.get();
		loan.setStatus(request.getStatus());		
		repo.save(loan);
		
		return new Response(202, "Successfully updated loan application");
	}

	@Override
	public Response delete(final Long loanId) {
		repo.deleteById(loanId);
		return new Response(200, "Successfully deleted loan application");
	}
}
