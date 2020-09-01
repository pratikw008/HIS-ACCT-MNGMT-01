package com.his.admin.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.his.admin.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SsnDTO {

	private String ssn;
	
	private String firstName;

	private String lastName;

	private Gender gender;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;

	private String stateName;
}
