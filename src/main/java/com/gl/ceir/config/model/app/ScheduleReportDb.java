package com.gl.ceir.config.model.app;
//
 

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
public class ScheduleReportDb implements Serializable { // extends BaseEntity

	private static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createdOn;

	@Column(nullable = false)
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date modifiedOn;

	private String category;
	private int reportName;
//	private int reportId;
	private String EmailId;
	private String Action;
	private String flag;
        
        
        
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "REPORT_ID"  , referencedColumnName = "REPORTNAME_ID" )
	private ReportDb reportDb;

        
         
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
        
        
        
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	 

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


	public ReportDb getReportDb() {
		return reportDb;
	}

	public void setReportDb(ReportDb reportDb) {
		this.reportDb = reportDb;
	}

	 

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		ScheduleReportDb.serialVersionUID = serialVersionUID;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScheduleReportDb{id=").append(id);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", modifiedOn=").append(modifiedOn);
        sb.append(", category=").append(category);
        sb.append(", reportName=").append(reportName);
        sb.append(", EmailId=").append(EmailId);
        sb.append(", Action=").append(Action);
        sb.append(", flag=").append(flag);
        sb.append(", reportDb=").append(reportDb);
        sb.append('}');
        return sb.toString();
    }
        
        
        
        
        
}



//import com.fasterxml.jackson.annotation.JsonFormat;
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import io.swagger.annotations.ApiModel;
//import java.util.Date;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Transient;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//@ApiModel
//@Entity
//public class ScheduleReportDb implements Serializable {     //extends BaseEntity
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private Date createdOn;
//
//    @Column(nullable = false)
//    @UpdateTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private Date modifiedOn;
//
//    private String category;
//    private String reportName;
//    private String EmailId;
//    private String Action;
//    private String flag;
//
////     
////    @OneToOne
////    @JoinColumn
////    private ReportDb reportDb;
// 
//    
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL, optional = false  )
//	@JoinColumn(name = "reportName", nullable = false)
//    private ReportDb reportDb;  
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }
//
//    public Date getModifiedOn() {
//        return modifiedOn;
//    }
//
//    public void setModifiedOn(Date modifiedOn) {
//        this.modifiedOn = modifiedOn;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public String getReportName() {
//        return reportName;
//    }
//
//    public void setReportName(String reportName) {
//        this.reportName = reportName;
//    }
//
//    public String getEmailId() {
//        return EmailId;
//    }
//
//    public void setEmailId(String EmailId) {
//        this.EmailId = EmailId;
//    }
//
//    public String getAction() {
//        return Action;
//    }
//
//    public void setAction(String Action) {
//        this.Action = Action;
//    }
//
//    public String getFlag() {
//        return flag;
//    }
//
//    public void setFlag(String flag) {
//        this.flag = flag;
//    }
//
//     
//
//    public ReportDb getReportDb() {
//        return reportDb;
//    }
//
//    public void setReportDb(ReportDb reportDb) {
//        this.reportDb = reportDb;
//    }
//
//    @Override
//    public String toString() {
//        return "ScheduleReportDb{" + "id=" + id + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", category=" + category + ", reportName=" + reportName + ", EmailId=" + EmailId + ", Action=" + Action + ", flag=" + flag + ", reportDb=" + reportDb + '}';
//    }
//
//    
//    
//    
//}



