package com.adt.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.adt.generators.StringPrefixedSequenceIdGenerator;

import lombok.Data;
@Data
@Entity
@Table(name = "SSN_MASTER")
public class SsnMasterEntity {

//	@SequenceGenerator(name = "ssn_seq", allocationSize = 1)
	@Id
	@Column(name = "SSN")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssn_seq")
	@GenericGenerator(name = "ssn_seq", strategy = "com.adt.generators.StringPrefixedSequenceIdGenerator",
				parameters = {
						@Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
						@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TCS_"),
						@Parameter(name=StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
				})
	private String ssn;

	@Column(name = "FIRST_NAME")
	private String fname;

	@Column(name = "LAST_NAME")
	private String lname;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
}
