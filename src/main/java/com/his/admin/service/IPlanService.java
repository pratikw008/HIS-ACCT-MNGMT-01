package com.his.admin.service;

import java.util.List;

import com.his.admin.dtos.PlanDTO;

public interface IPlanService {
	
	public PlanDTO savePlan(PlanDTO planDTO);
	
	public List<PlanDTO> getAllPlans();
	
	public PlanDTO editById(Long id);
	
	public PlanDTO updatePlan(PlanDTO planDTO);
	
	public Boolean deleteById(Long id);
	
	public Boolean activePlanById(Long id);
}
