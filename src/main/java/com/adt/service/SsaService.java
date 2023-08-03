package com.adt.service;

import java.util.List;

import com.adt.model.SsnEnrollmentRequest;

public interface SsaService {
	
	public List<String> getAllStateNames();
	
	public String ssnEnrollment(SsnEnrollmentRequest req);
	
	public String checkEnrollment(String ssn, String stateName);

}
