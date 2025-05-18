package com.gl.ceir.config.model.app;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.gl.ceir.config.model.constants.TransactionState;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class PendingActionStates implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private TransactionState currentState;

	@Enumerated(EnumType.STRING)
	private TransactionState nextState;

	@ManyToOne
	@JoinColumn
	private Action action;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TransactionState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(TransactionState currentState) {
		this.currentState = currentState;
	}

	public TransactionState getNextState() {
		return nextState;
	}

	public void setNextState(TransactionState nextState) {
		this.nextState = nextState;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
