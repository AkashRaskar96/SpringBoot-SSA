package com.adt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.entities.SsnMasterEntity;
import com.adt.entities.StatesMasterEntity;
import com.adt.model.SsnEnrollmentRequest;
import com.adt.repository.SsnMasterRepository;
import com.adt.repository.StatesMasterRepository;

@Service
public class SsaServiceImpl implements SsaService {

	@Autowired
	private SsnMasterRepository ssnRepo;
	
	@Autowired
	private StatesMasterRepository statesRepo;
	
	@Override
	public List<String> getAllStateNames() {
		return statesRepo.findByStateNames();
	}
	
	@Override
	public String ssnEnrollment(SsnEnrollmentRequest req) {
		SsnMasterEntity entity=new SsnMasterEntity();
		BeanUtils.copyProperties(req,entity);
		SsnMasterEntity savedEntity=ssnRepo.save(entity);
		if(savedEntity!=null && savedEntity.getSsn() != null) {
			return savedEntity.getSsn();
		}else {
			//ResourceNotCreatedException
			throw new RuntimeException("ResourceNotCreatedException..");
		}
		
	}

	@Override
	public String checkEnrollment(String ssn, String stateName) {
		SsnMasterEntity entity=ssnRepo.findBySsnAndStateName(ssn,stateName);
		if(entity!=null && entity.getSsn() != null) {
			return "VALID-SSN";
		}else {
//			//InvalidSsnException
//			throw new RuntimeException("InvalidSsnException");
			return "IN-VALID";
		}
	}

	

}
