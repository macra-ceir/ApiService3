package com.gl.ceir.config.service.businesslogic;

import com.gl.ceir.config.model.constants.ConsignmentStatus;

public class StateMachine {
	
	public static boolean isConsignmentStatetransitionAllowed(String userType, int currentStatus) {
		if("CEIRADMIN".equalsIgnoreCase(userType)) {
			return ConsignmentStatus.PENDING_APPROVAL_FROM_CEIR_AUTHORITY.getCode() == currentStatus;
		}else if("CUSTOM".equalsIgnoreCase(userType))
			return ConsignmentStatus.PENDING_APPROVAL_FROM_CUSTOMS.getCode() == currentStatus;
		
		return Boolean.FALSE;
	}

}
