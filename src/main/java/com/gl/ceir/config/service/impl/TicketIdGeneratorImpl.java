package com.gl.ceir.config.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.gl.ceir.config.service.TicketIdGenerator;

@Service
public class TicketIdGeneratorImpl implements TicketIdGenerator {
	private AtomicInteger ticketIdPrefix = new AtomicInteger(1);

	public synchronized String getTicketId() {
		if (ticketIdPrefix.get() >= 1000)
			ticketIdPrefix.set(1);
		return "" + ticketIdPrefix.get() + System.currentTimeMillis();
	}

}
