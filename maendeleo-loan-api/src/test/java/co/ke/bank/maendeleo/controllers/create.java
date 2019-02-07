package co.ke.bank.maendeleo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.ke.bank.maendeleo.entities.LoanAmount;
import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.enums.Currency;
import co.ke.bank.maendeleo.enums.LoanStatus;
import co.ke.bank.maendeleo.enums.LoanType;
import co.ke.bank.maendeleo.pojos.LoanApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;
import co.ke.bank.maendeleo.services.LoanApplicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanApplicationController.class)
public class create {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private LoanApplicationService service;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() throws JsonProcessingException, Exception{
		
//		LoanApplication application = new LoanApplication();
//		application.setType(LoanType.NORMAL);
//		application.setPurpose("Buy house hold stuff");
//		application.setStatus(LoanStatus.PENDING);
//		
//		LoanAmount amount = new LoanAmount();
//		amount.setCurrency(Currency.KES);
//		amount.setAmount(20000L);
//		
//		LoanApplicationRequest request = new LoanApplicationRequest();
//		request.setMemberId(1L);
//		request.setAmount(amount);
//		request.setApplication(application);
//		
//		Response response = new Response(200, "Successfully added loan application");
//		when(service.create(request)).thenReturn(response);
//	 
//	    mvc.perform(get("/api/loan")
//	      .contentType(MediaType.APPLICATION_JSON))
//	      .andExpect(status().isOk())
//	      .andExpect(jsonPath("$.code").value(response.getCode()));
	}

}
