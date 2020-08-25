package com.his.admin.utils;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.his.admin.dtos.PlanDTO;
import com.his.admin.model.PlanEntity;

public class PlanMapper {
	
	public static PlanDTO convertPlanEntityToPlanDTO(PlanEntity planEntity) {
		return Optional.ofNullable(planEntity)
					   .map(planEnt -> {
						   PlanDTO planDTO = new PlanDTO();
						   BeanUtils.copyProperties(planEnt, planDTO);
						   return planDTO;
					   })
					   .orElseThrow(() -> new RuntimeException("Failed To Convert PlanEntity To PlanDTO"));
	}
	
	public static PlanEntity convertPlanDTOToPlanEntity(PlanDTO planDTO) {
		return Optional.ofNullable(planDTO)
					   .map(dto -> {
						   PlanEntity planEntity = new PlanEntity();
						   BeanUtils.copyProperties(dto, planEntity);
						   return planEntity;
					   })
					   .orElseThrow(() -> new RuntimeException("Failed To Convert PlanDTO To PlanEntity"));
	}
}