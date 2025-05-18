package com.gl.ceir.config.repository.app;

import com.gl.ceir.config.model.app.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long>, JpaSpecificationExecutor<Notification>{

	public Notification save(Notification notification);

	Notification findByCorelationIdAndOperatorName(String correlationId, String operatorName);
}
