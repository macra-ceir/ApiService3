package com.gl.ceir.config.model.app;

import java.util.Date;

public class FilterRequest {

    
     String user_type;  String feature ;  Long imei_type ;
 String msisdn; String identifierType ;
    
    private Long id;
    private Integer userId;
    private Long importerId;
    private String nid;
    private String txnId;
    private String startDate;
    private String endDate;
    private Integer consignmentStatus;
    private String roleType;
    private Integer requestType;
    private Integer sourceType;
    private String userType;
    private String filteredUserType;
    private Integer featureId;
    private String featureName;
    private String subFeatureName;
    private String userName;
    private Integer userTypeId;
    private String searchString;
    private Integer taxPaidStatus;
    private Integer deviceIdType;
    private Integer deviceType;
    private Integer type;
    private Integer channel;

    private Integer status;

    private Integer operatorTypeId;
    private String origin;

    private String tac;

    // Mapping for parent child tags.
    private String tag;
    private String childTag;
    private Integer parentValue;

    private String imei;
    private Long contactNumber;
    private Integer filteredUserId;

    private String state;

    private String ruleName;

    private String remark;

    private String displayName;

    private String quantity;

    public String deviceQuantity;

    private String subject;

    private String supplierName;
    private String fileName, nationality;
    private String columnName;
    private String sort, blockingTypeFilter;

    public String visaType, visaNumber, visaExpiryDate;
    public String order, orderColumnName;
    public String description, name;
    private String publicIp;
    private String browser;

    private String category;
    private int reportName;
    private int reportId;
    private String EmailId;
    private String Action;
    private String flag;

    private Date createdOn;
    private Date modifiedOn;

    
    
    private String details;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    
    
    
    
    
    
    
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Long getImei_type() {
        return imei_type;
    }

    public void setImei_type(Long imei_type) {
        this.imei_type = imei_type;
    }

    
    
    
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReportName() {
        return reportName;
    }

    public void setReportName(int reportName) {
        this.reportName = reportName;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String Action) {
        this.Action = Action;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Integer featureId) {
        this.featureId = featureId;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getImporterId() {
        return importerId;
    }

    public void setImporterId(Long importerId) {
        this.importerId = importerId;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getConsignmentStatus() {
        return consignmentStatus;
    }

    public void setConsignmentStatus(Integer consignmentStatus) {
        this.consignmentStatus = consignmentStatus;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public String getFilteredUserType() {
        return filteredUserType;
    }

    public void setFilteredUserType(String filteredUserType) {
        this.filteredUserType = filteredUserType;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getSubFeatureName() {
        return subFeatureName;
    }

    public void setSubFeatureName(String subFeatureName) {
        this.subFeatureName = subFeatureName;
    }

    public Integer getTaxPaidStatus() {
        return taxPaidStatus;
    }

    public void setTaxPaidStatus(Integer taxPaidStatus) {
        this.taxPaidStatus = taxPaidStatus;
    }

    public Integer getDeviceIdType() {
        return deviceIdType;
    }

    public void setDeviceIdType(Integer deviceIdType) {
        this.deviceIdType = deviceIdType;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOperatorTypeId() {
        return operatorTypeId;
    }

    public void setOperatorTypeId(Integer operatorTypeId) {
        this.operatorTypeId = operatorTypeId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getChildTag() {
        return childTag;
    }

    public void setChildTag(String childTag) {
        this.childTag = childTag;
    }

    public Integer getParentValue() {
        return parentValue;
    }

    public void setParentValue(Integer parentValue) {
        this.parentValue = parentValue;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getFilteredUserId() {
        return filteredUserId;
    }

    public void setFilteredUserId(Integer filteredUserId) {
        this.filteredUserId = filteredUserId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDeviceQuantity() {
        return deviceQuantity;
    }

    public void setDeviceQuantity(String deviceQuantity) {
        this.deviceQuantity = deviceQuantity;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getBlockingTypeFilter() {
        return blockingTypeFilter;
    }

    public void setBlockingTypeFilter(String blockingTypeFilter) {
        this.blockingTypeFilter = blockingTypeFilter;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public String getVisaExpiryDate() {
        return visaExpiryDate;
    }

    public void setVisaExpiryDate(String visaExpiryDate) {
        this.visaExpiryDate = visaExpiryDate;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderColumnName() {
        return orderColumnName;
    }

    public void setOrderColumnName(String orderColumnName) {
        this.orderColumnName = orderColumnName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    
    

}
