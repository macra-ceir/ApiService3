/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author maverick
 */
@Entity

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OperatorSeries implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime modifiedOn;

    @Column
    private int seriesStart;

    @Column
    private String seriesType;

    @Column
    private String operatorName;

    @Column
    private int seriesEnd;


    public OperatorSeries() {
    }

}
