package com.his.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HIS_USER_TBL")
@EntityListeners(AuditingEntityListener.class)
@Builder
public class UserEntity {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "USER_PWD")
	private String pazzword;
	
	@Column(name = "USER_GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	//@Column(name = "USER_ROLE")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID")
	private Role role;
	
	@Column(name = "USER_ACCT_STATUS")
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus;
	
	@Column(name = "USER_ACCT_STATE")
	@Enumerated(EnumType.STRING)
	private DeleteState deleteState;
	
	@CreatedDate
	@Column(name = "USER_CREATED_ON", updatable = false)
	private LocalDateTime createdOn;

	@LastModifiedDate
	@Column(name = "USER_MODIFIED_ON", insertable = false)
	private LocalDateTime modifiedAt;
}