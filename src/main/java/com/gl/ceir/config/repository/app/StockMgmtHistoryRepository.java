package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.StockMgmtHistoryDb;

public interface StockMgmtHistoryRepository extends JpaRepository<StockMgmtHistoryDb, Long> {

}
