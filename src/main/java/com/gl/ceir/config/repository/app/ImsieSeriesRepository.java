package com.gl.ceir.config.repository.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ceir.config.model.app.ImsieSeries;

public interface ImsieSeriesRepository extends JpaRepository<ImsieSeries, Long> {

}
