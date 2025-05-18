package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.Action;
import com.gl.ceir.config.model.app.PendingActionStates;
import com.gl.ceir.config.model.constants.TransactionState;

public interface PendingActionsStatesRepositoy extends JpaRepository<PendingActionStates, Integer> {

	public PendingActionStates findByCurrentStateAndNextStateAndAction(TransactionState currentState,
			TransactionState nextState, Action action);
}
