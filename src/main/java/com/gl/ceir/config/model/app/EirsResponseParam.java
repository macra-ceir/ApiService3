package com.gl.ceir.config.model.app;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Cacheable
@Data

// @AuditTable(value = "sys_param_aud", schema = "aud")

public class EirsResponseParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;
    private String value;
    private Integer type; // have two values USER/SYSTEM.
    private String featureName;
	private String language;

}
