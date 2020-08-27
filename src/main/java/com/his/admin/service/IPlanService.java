package com.his.admin.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.his.admin.dtos.PlanDTO;

public interface IPlanService {
	
	public PlanDTO savePlan(PlanDTO planDTO);
	
	public List<PlanDTO> getAllPlans();
	
	public Page<PlanDTO> getAllPlansWithPaginationAndSorting(int pageNo,int pageSize);
	
	public PlanDTO editById(Long id);
	
	public PlanDTO updatePlan(PlanDTO planDTO);
	
	public Boolean deleteById(Long id);
	
	public Boolean activePlanById(Long id);
}
