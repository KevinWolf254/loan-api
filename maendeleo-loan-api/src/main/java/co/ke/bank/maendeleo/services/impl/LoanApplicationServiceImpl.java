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
import co.ke.bank.maendeleo.enums.LoanStatus;
import co.ke.bank.maendeleo.pojos.Application;
import co.ke.bank.maendeleo.pojos.LoanApplicationRequest;
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
	public Response create(final LoanApplicationRequest request) {
		// find member's account by member id
		final Optional<Account> account = accountRepo.findByMemberIdentityNo(request.getMemberId());
		if (!account.isPresent())
			return new Response(400, "Bad Request");
		
		// save loan amount
		final LoanAmount amount = amountRepo
				.save(new LoanAmount(request.getAmount().getCurrency(), request.getAmount().getAmount()));
		
		// get application details and save application
		final Application _app = request.getApplication();
		repo.save(new LoanApplication(_app.getType(), _app.getPurpose(), LoanStatus.PENDING, account.get(), amount));

		// determine if there are other bank loans
		if (!request.getOtherLoans().isEmpty()) {
			// iterate through the array
			request.getOtherLoans().stream().forEach(loan -> {
				// save details of other loans
				final Optional<Bank> bank = bankRepo.findByName(loan.getBankName());
				if (bank.isPresent()) {
						// save loan amount
						final OtherBankLoanAmount amountL = amountLoanRepo.save(new OtherBankLoanAmount(
								loan.getCurrency(), loan.getAmount(), loan.getOutStandingBalance()));
						// save loan
						otherLoanRepo.save(new OtherBankLoan(loan.getDateGranted(), loan.getRepaymentPeriod(),
								bank.get(), account.get(), amountL));
				}
			});
		}
		return new Response(200, "Successfully added loan application");
	}

	@Override
	public List<LoanApplication> read(final int memberIdNo) {
		final Optional<Account> account = accountRepo.findByMemberIdentityNo(memberIdNo);
		if (!account.isPresent())
			return new ArrayList<LoanApplication>();

		return repo.findByAccountId(account.get().getId());
	}

	@Override
	public Response update(final LoanApplication application) {
		repo.save(application);
		return new Response(200, "Successfully updated loan application");
	}

	@Override
	public Response delete(final Long loanId) {
		repo.deleteById(loanId);
		return new Response(200, "Successfully deleted loan application");
	}
}
