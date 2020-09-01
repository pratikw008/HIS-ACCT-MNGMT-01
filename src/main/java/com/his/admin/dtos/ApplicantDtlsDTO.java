package com.his.admin.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.his.admin.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDtlsDTO {
	
	private String applicantId;
	
	private String firstName;
	
	private String lastName;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;
	
	private Gender gender;
	
	private String ssnNo;
	
	private String phoneNumber;
	
	private String applicantEmail;
}