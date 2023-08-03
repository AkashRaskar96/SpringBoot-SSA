package com.adt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adt.model.SsnEnrollmentRequest;
import com.adt.service.SsaService;

@RestController
public class SSNEnrollRestController {

	@Autowired
	private SsaService service;
	
	@PostMapping(value = "/enroll", consumes = {"application/json", "application/xml"})
	public ResponseEntity<String> enrollSSN(@RequestBody SsnEnrollmentRequest model){
		String msg=service.ssnEnrollment(model);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
}
