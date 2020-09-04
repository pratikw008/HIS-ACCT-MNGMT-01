package com.his.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.his.model.DeleteState;
import com.his.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDtlsDTO {
	
	private String applicationId;
	
	private String firstName;
	
	private String lastName;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;
	
	private Gender gender;
	
	private String ssnNo;
	
	private String phoneNumber;
	
	private String applicantEmail;
	
	private DeleteState deleteState;
}