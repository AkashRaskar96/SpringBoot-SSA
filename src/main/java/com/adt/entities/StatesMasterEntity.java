package com.adt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STATES_MASTER")
public class StatesMasterEntity {
	@Id
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "STATE_NAME")
	private String stateName;

}
