package com.his.admin.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.his.admin.model.PlanAccountState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDTO {
	
	private Long planId;
	
	private String planName;
	
	private String planDescription;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate planStartDate;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate planEndDate;
	
	private PlanAccountState planAccountState;
}
