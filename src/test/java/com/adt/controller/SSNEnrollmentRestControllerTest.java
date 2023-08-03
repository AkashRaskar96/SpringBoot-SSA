package com.adt.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.adt.model.SsnEnrollmentRequest;
import com.adt.service.SsaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SSNEnrollRestController.class)
public class SSNEnrollmentRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SsaService service;
	
	public void enrollSSNTest() throws Exception {
		when(service.ssnEnrollment(Mockito.any(SsnEnrollmentRequest.class)))
									.thenReturn("6868686868");
		
		SsnEnrollmentRequest req=new SsnEnrollmentRequest();
		req.setFname("Test1");
		req.setLname("Test2");
		req.setDob(new Date());
		req.setGender("Male");
		req.setStateName("RI");
		
		ObjectMapper mapper=new ObjectMapper();
		String reqJson=mapper.writeValueAsString(req);
		
		MockHttpServletRequestBuilder postReq = MockMvcRequestBuilders.post("/enroll")
																.contentType(MediaType.APPLICATION_JSON)
																.content(reqJson);
		
		MvcResult result=mockMvc.perform(postReq).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		System.out.println("Response :: "+response.getContentAsString());
		int status=response.getStatus();
		assertEquals(201, status);
	}

}
