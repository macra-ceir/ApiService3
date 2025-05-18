//package com.gl.ceir.config.controller;
//
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.converter.json.MappingJacksonValue;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import com.gl.ceir.config.model.AuditTrail;
//import com.gl.ceir.config.model.BlacklistDbHistory;
//import com.gl.ceir.config.model.ConsignmentMgmtHistoryDb;
//import com.gl.ceir.config.model.DeviceDbHistory;
//import com.gl.ceir.config.model.FilterRequest;
//import com.gl.ceir.config.model.GreylistDbHistory;
//import com.gl.ceir.config.model.MessageConfigurationHistoryDb;
//import com.gl.ceir.config.model.Notification;
//import com.gl.ceir.config.model.PolicyConfigurationHistoryDb;
//import com.gl.ceir.config.model.StockMgmtHistoryDb;
//import com.gl.ceir.config.model.StolenAndRecoveryHistoryMgmt;
//import com.gl.ceir.config.model.SystemConfigurationHistoryDb;
//import com.gl.ceir.config.service.impl.HistoryServiceImpl;
//
////import io.swagger.annotations.ApiOperation;
//
//@RestController
//public class HistoryController {
//
//
//	private static final Logger logger = Logger.getLogger(HistoryServiceImpl.class);
//
//	@Autowired
//	HistoryServiceImpl historyServiceImpl;
//
//
//	//@ApiOperation(value = "View All Record of policy history Db.", response = PolicyConfigurationHistoryDb.class)
//	@RequestMapping(path = "/history/policy", method = RequestMethod.POST)
//	public MappingJacksonValue viewPolicy(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view policy historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//		Page<PolicyConfigurationHistoryDb> policyDb = historyServiceImpl.ViewAllPolicyHistory(pageNo, pageSize);
//
//		logger.info("Policy history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//	}
//
//	//@ApiOperation(value = "View All Record of Message history Db.", response = MessageConfigurationHistoryDb.class)
//	@RequestMapping(path = "/history/message", method = RequestMethod.POST)
//	public MappingJacksonValue viewMessage(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Message historyDetails Page No=" + pageNo + " Pagesize=" + pageNo);
//
//		Page<MessageConfigurationHistoryDb> policyDb = historyServiceImpl.ViewAllMessageHistory(pageNo, pageSize);
//
//		logger.info("Message history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//
//	}
//
//	//@ApiOperation(value = "View All Record of System history Db.", response = SystemConfigurationHistoryDb.class)
//	@RequestMapping(path = "/history/system", method = RequestMethod.POST)
//	public MappingJacksonValue viewSystem(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view System historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//		Page<SystemConfigurationHistoryDb> policyDb = historyServiceImpl.ViewAllSystemHistory(pageNo, pageSize);
//
//		logger.info("Message history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//
//	}
//
//	//@ApiOperation(value = "View All Record of BlackList history Db.", response = BlacklistDbHistory.class)
//	@RequestMapping(path = "/history/Black", method = RequestMethod.POST)
//	public MappingJacksonValue viewBlackList(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Black historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<BlacklistDbHistory> policyDb = historyServiceImpl.ViewAllBlackHistory(pageNo, pageSize);
//
//		logger.info("BlackLIst history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//
//	}
//
//	//@ApiOperation(value = "View All Record of GreyList history Db.", response = GreylistDbHistory.class)
//	@RequestMapping(path = "/history/Grey", method = RequestMethod.POST)
//	public MappingJacksonValue viewGreyList(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Grey historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<GreylistDbHistory> policyDb = historyServiceImpl.ViewAllGreyHistory(pageNo, pageSize);
//
//		logger.info("Grey history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//
//	}
//
//	//@ApiOperation(value = "View All Record of Device history Db.", response = DeviceDbHistory.class)
//	@RequestMapping(path = "/history/device", method = RequestMethod.POST)
//	public MappingJacksonValue viewDevice(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Device historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<DeviceDbHistory> policyDb = historyServiceImpl.ViewAllDeviceHistory(pageNo, pageSize);
//
//		logger.info("Device history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//
//	}
//
//
//
//	//@ApiOperation(value = "View All Record of Device history Db.", response = StolenAndRecoveryHistoryMgmt.class)
//	@RequestMapping(path = "/history/StlAndRcry", method = RequestMethod.POST)
//	public MappingJacksonValue viewStolenAndRecovery(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Stolen And Recovery  historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<StolenAndRecoveryHistoryMgmt> policyDb = historyServiceImpl.ViewAllStolenAndRecoveryHistory(pageNo, pageSize);
//
//		logger.info("Stolen And Recovery  history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//
//	}
//
//
//	//@ApiOperation(value = "View All Record of Consignment history Db.", response = ConsignmentMgmtHistoryDb.class)
//	@RequestMapping(path = "/history/consignment", method = RequestMethod.POST)
//	public MappingJacksonValue viewConsignment(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Consignment historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<ConsignmentMgmtHistoryDb> policyDb = historyServiceImpl.ViewAllConsignmentHistory(pageNo, pageSize);
//
//		logger.info("Consignment history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//	}
//
//
//
//	//@ApiOperation(value = "View All Record of Device history Db.", response = StockMgmtHistoryDb.class)
//	@RequestMapping(path = "/history/Stock", method = RequestMethod.POST)
//	public MappingJacksonValue viewStock(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Device historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<StockMgmtHistoryDb> policyDb = historyServiceImpl.ViewAllStockHistory(pageNo, pageSize);
//
//		logger.info("Stock history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//	}
//
//
//	//@ApiOperation(value = "View All Record of Audit  Db.", response = AuditTrail.class)
//	@RequestMapping(path = "/history/audit", method = RequestMethod.POST)
//	public MappingJacksonValue viewAudit(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Audit historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<AuditTrail> policyDb = historyServiceImpl.ViewAllAuditHistory(pageNo, pageSize);
//
//		logger.info("Audit history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//	}
//
//	//@ApiOperation(value = "View All Record of Audit  Db.", response = Notification.class)
//	@RequestMapping(path = "/history/Notification", method = RequestMethod.POST)
//	public MappingJacksonValue viewNotification(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view Notification historyDetails Page No="+pageNo+" Pagesize="+pageNo);
//
//		Page<Notification> policyDb = historyServiceImpl.ViewAllNotificationHistory(pageNo, pageSize);
//
//		logger.info("Notification history Response="+policyDb);
//		MappingJacksonValue mapping = new MappingJacksonValue(policyDb);
//		return mapping;
//	}
//	
//	//@ApiOperation(value = "View All Record of Notification Db.", response = Notification.class)
//	@RequestMapping(path = "v2/history/Notification", method = RequestMethod.POST)
//	public MappingJacksonValue viewNotification(@RequestBody FilterRequest filterRequest,
//			@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
//			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
//
//		logger.info("Request to view v2 Notification historyDetails = " + filterRequest);
//
//		Page<Notification> notification = historyServiceImpl.ViewAllNotificationHistory(pageNo, pageSize, filterRequest);
//
//		logger.info("Notification history Response= " + notification);
//		MappingJacksonValue mapping = new MappingJacksonValue(notification);
//		return mapping;
//	}
//
//}
