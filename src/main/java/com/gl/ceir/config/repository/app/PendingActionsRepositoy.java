package com.gl.ceir.config.repository.app;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gl.ceir.config.model.app.PendingActions;
import com.gl.ceir.config.model.constants.TransactionState;

public interface PendingActionsRepositoy extends JpaRepository<PendingActions, String> {

	public PendingActions findByMsisdn(Long msisdn);

	public PendingActions findByImei(Long imei);

	public PendingActions findByMsisdnAndImei(Long msisdn, Long imei);

	@Transactional
	@Modifying
	@Query("UPDATE PendingActions P SET P.transactionState = ?1 WHERE P.ticketId = ?2")
	public int updateTransactionStateByTicketID(TransactionState transactionState, String ticketId);

	public List<PendingActions> findByTransactionState(TransactionState transactionState);

	// Ready to Block IMEI
	@Query("select P from PendingActions P where P.transactionState=?1 and P.endDateforUserAction <= ?2")
	public List<PendingActions> findByTransactionStateAndEndDateforUserAction(TransactionState transactionState,
			Date endDateforUserAction);

	@Query("select P from PendingActions P where P.transactionState=?1 and P.reminderDate < ?2")
	public List<PendingActions> findByTransactionStateAndReminderDate(TransactionState transactionState,
			Date endDateforUserAction);
}
