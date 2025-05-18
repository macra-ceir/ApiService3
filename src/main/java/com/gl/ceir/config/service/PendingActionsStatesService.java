package com.gl.ceir.config.service;

import com.gl.ceir.config.model.app.Action;
import com.gl.ceir.config.model.app.PendingActionStates;
import com.gl.ceir.config.model.constants.TransactionState;

public interface PendingActionsStatesService extends RestServices<PendingActionStates> {



	// new changes to here stage changes
	public boolean isStateChangeAllowed(TransactionState currentState, TransactionState nextState, Action action);
}
