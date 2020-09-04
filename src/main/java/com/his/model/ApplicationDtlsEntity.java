package com.his.model;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.his.utils.CustomIdGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "APPLICATION_TBL")
@EntityListeners(AuditingEntityListener.class)
public class ApplicationDtlsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_dtls_seq")
	@GenericGenerator(name = "application_dtls_seq", strategy = "com.his.utils.CustomIdGenerator",
			parameters = {
					@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "AR_"),
					@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
			})
	@Column(name = "APPLICATION_ID")
	private String applicationId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "APPLICANT_DOB")
	private LocalDate dateOfBirth;
	
	@Column(name = "APPLICANT_GENDER")
	@Enumerated(EnumType.STRING )
	private Gender gender;
	
	@Column(name = "APPLICANT_SSN_NO")
	private String ssnNo;
	
	@Column(name = "APPLICANT_PH_NO")
	private String phoneNumber;
	
	@Column(name = "APPLICANT_EMAIL")
	private String applicantEmail;
	
	@Column(name = "APPLICATION_STATE")
	@Enumerated(EnumType.STRING)
	private DeleteState deleteState;
	
	@CreatedDate
	@Column(name = "CREATED_AT", updatable = false)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(name = "Modified_AT", insertable = false)
	private LocalDateTime modifiedAt;
}
