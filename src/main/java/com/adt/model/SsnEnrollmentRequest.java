package com.adt.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@XmlRootElement //If we want to take Xml as request then
public class SsnEnrollmentRequest {
	
	private String fname;
	
	private String lname;
	
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date dob;
	
	private String gender;
	
	private String stateName;

}
