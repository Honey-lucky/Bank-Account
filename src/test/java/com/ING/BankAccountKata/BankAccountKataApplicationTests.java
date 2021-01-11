package com.ING.BankAccountKata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ING.BankAccountKata.domain.Account;
import com.ING.BankAccountKata.repository.AccountServiceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;

@SpringBootTest
class BankAccountKataApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired

	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	AccountServiceRepository repository;
	
	  
	  @Test public void addCustomerTest() throws Exception { 
		  
		  Account c = new
	  Account(); 
	  c.setAccountid((long) 1056451.0);
c.setAmount(null);
	  c.setName("Minchu");
	  		
	  
	 
	  c.setStatus("Active"); String jsonRequest = mapper.writeValueAsString(c);
	  MvcResult result =
	  mvc.perform(post("/addcustomer")).andExpect(status().isOk()).
	  andReturn(); String actualresponse =
	  result.getResponse().getContentAsString(); 
	  Response expectresponse =mapper.readValue(actualresponse, Response.class);
	Assertions.assertEquals(expectresponse,actualresponse);
	
	 
	  }
	  
	  

}
