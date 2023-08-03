package com.adt.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adt.entities.StatesMasterEntity;

public interface StatesMasterRepository extends JpaRepository<StatesMasterEntity, Serializable> {

	@Query(value = "select stateName from StatesMasterEntity")
	public List<String> findByStateNames();
}
