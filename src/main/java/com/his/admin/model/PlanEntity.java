package com.his.admin.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HIS_PLAN_TBL")
@EntityListeners(AuditingEntityListener.class)
public class PlanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLAN_ID")
	private Long planId;
	
	@Column(name = "PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_DESCR")
	private String planDescription;
	
	@Column(name = "PLAN_START_DT")
	private LocalDate planStartDate;
	
	@Column(name = "PLAN_END_DT")
	private LocalDate planEndDate;
	
	@Column(name = "PLAN_STATE")
	@Enumerated(EnumType.STRING)
	private PlanAccountState planAccountState;
	
	@CreatedDate
	@Column(name = "PLAN_CREATED_AT", updatable = false)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name = "PLAN_MODIFIED_AT", insertable = false)
	private LocalDateTime modifiedAt;
}
