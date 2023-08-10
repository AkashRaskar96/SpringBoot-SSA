package com.adt.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adt.service.SsaService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SsnValidationRestControllerTest2 {

	private MockMvc mockMvc;

	@MockBean
	private SsaService service;

	@InjectMocks
	SsnValidationRestController ssnValidationRestController;

	@Test
	public void validateTest() throws Exception {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(ssnValidationRestController).build();

		when(service.checkEnrollment("101", "RI")).thenReturn("IN-VALID");
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/ssn/validate/101/RI")
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(req).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String resString = response.getContentAsString();
		System.out.println("Response from API :: " + resString);
		assertEquals("IN-VALID", resString);
	}
}
