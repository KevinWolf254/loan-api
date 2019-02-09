package co.ke.bank.maendeleo.controllers;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.*;

import java.util.Collections;

//import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.ke.bank.maendeleo.entities.LoanAmount;
import co.ke.bank.maendeleo.entities.LoanApplication;
import co.ke.bank.maendeleo.enums.Currency;
import co.ke.bank.maendeleo.enums.LoanStatus;
import co.ke.bank.maendeleo.enums.LoanType;
import co.ke.bank.maendeleo.pojos.ApplicationRequest;
import co.ke.bank.maendeleo.pojos.Response;
import co.ke.bank.maendeleo.services.LoanApplicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanApplicationController.class)
public class LoanApplicationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper map;
	
	@MockBean
	private LoanApplicationService service;
	
	private ApplicationRequest request;
	private LoanApplication loanApp;
	private Response response = new Response(201, "successfully created");
	private String urlCreate = "/loan";

	@Before
	public void setUp() throws Exception {
		final LoanAmount amount = new LoanAmount(Currency.KES, 200000);
		amount.setId(1L);
		
		loanApp = new LoanApplication(LoanType.NORMAL, "Personal Use", 
				LoanStatus.PENDING, amount);
		loanApp.setId(1L);
		
		request = new ApplicationRequest();
		request.setIdentityNo(25023590);
		request.setLoan(loanApp);
		request.setOtherLoans(Collections.emptyList());

		Mockito.when(service.create(request)).thenReturn(response);
		Mockito.when(service.read(1)).thenReturn(Collections.singletonList(loanApp));
		Mockito.when(service.update(loanApp)).thenReturn(new Response(202, "successfully updated"));
		Mockito.when(service.delete(1L)).thenReturn(new Response(200, "successfully deleted"));
	}

	@Test
	public void create_thenReturn() throws JsonProcessingException, Exception {
		
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(urlCreate)
				.accept(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON);
		
		final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		final MockHttpServletResponse httpResponse = result.getResponse();
		
		//jUnit
//		assertEquals(response.getCode(), httpResponse.getStatus());
		//hamcrest
//		assertThat(response.getCode(), equalTo(httpResponse.getStatus()));
		//assertJ
		assertThat(response.getCode()).isEqualTo(httpResponse.getStatus());
	}


	@Test
	public void read_thenReturn() throws JsonProcessingException, Exception{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(urlCreate + "/1")
				.accept(MediaType.APPLICATION_JSON);
		
		final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		final MockHttpServletResponse httpResponse = result.getResponse();

		String expected = map.writeValueAsString(Collections.singletonList(loanApp));
		String actual = httpResponse.getContentAsString();
		
		//asserts data match
		assertThat(expected).isEqualTo(actual);
		//asserts response code match
		assertThat(HttpStatus.OK.value()).isEqualTo(httpResponse.getStatus());

	}
	
	@Test
	public void update_thenReturn() throws JsonProcessingException, Exception{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.put(urlCreate)
				.accept(MediaType.APPLICATION_JSON)
				.content(map.writeValueAsString(loanApp))
				.contentType(MediaType.APPLICATION_JSON);
		

		final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		final MockHttpServletResponse httpResponse = result.getResponse();
		
		//asserts response code match
		assertThat(HttpStatus.ACCEPTED.value()).isEqualTo(httpResponse.getStatus());
	}

	@Test
	public void delete_thenReturn() throws JsonProcessingException, Exception{
		final MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete(urlCreate + "/1")
				.accept(MediaType.APPLICATION_JSON);
		
		final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		final MockHttpServletResponse httpResponse = result.getResponse();

		//asserts response code match
		assertThat(HttpStatus.OK.value()).isEqualTo(httpResponse.getStatus());
	}
}
