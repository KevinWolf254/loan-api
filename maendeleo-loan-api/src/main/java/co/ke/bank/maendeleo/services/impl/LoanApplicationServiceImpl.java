package co.ke.bank.maendeleo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.bank.maendeleo.RestResponseExceptionHandler;
import co.ke.bank.maendeleo.entities.Account;
import co.ke.bank.maendeleo.entities.LoanAmount;
import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.pojos.LoanApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;
import co.ke.bank.maendeleo.repositories.AccountRepository;
import co.ke.bank.maendeleo.repositories.LoanAmountRepository;
import co.ke.bank.maendeleo.repositories.LoanApplicationRepository;
import co.ke.bank.maendeleo.services.LoanApplicationService;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	@Autowired
	private LoanApplicationRepository repo;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private LoanAmountRepository amountRepo;
	
	private final static Logger LOG = LoggerFactory.getLogger(LoanApplicationServiceImpl.class);

	@Override
	public Response create(final LoanApplicationRequest request) {
		final Optional<Account> account = accountRepo.findByMemberId(request.getMemberId());
		LOG.info("member id: " + request.getMemberId());
		if(!account.isPresent()) 
			return new Response(400, "Bad Request");
		
//		final LoanApplication application = request.getApplication();
//		final LoanAmount amount = amountRepo.save(request.getAmount());
//		application.setAccount(account.get());
//		application.setAmount(amount);
		
//		repo.save(application);
		return new Response(200, "Successfully added loan application");
	}

	@Override
	public List<LoanApplication> read(final Long memberIdNo) {
		final Optional<Account> account = accountRepo.findByMemberId(memberIdNo);
		if(!account.isPresent()) 
			return new ArrayList<LoanApplication>();
		
		return repo.findByAccountId(account.get().getId());
	}

	@Override
	public Response update(LoanApplication application) {
		repo.save(application);
		return new Response(200, "Successfully updated loan application");
	}

	@Override
	public Response delete(Long loanId) {
		repo.deleteById(loanId);
		return new Response(200, "Successfully deleted loan application");
	}

}
