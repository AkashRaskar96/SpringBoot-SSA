package com.adt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.entities.SsnMasterEntity;

public interface SsnMasterRepository extends JpaRepository<SsnMasterEntity, Serializable> {
						   
	public SsnMasterEntity findBySsnAndStateName(String ssn,String stateName);
}
