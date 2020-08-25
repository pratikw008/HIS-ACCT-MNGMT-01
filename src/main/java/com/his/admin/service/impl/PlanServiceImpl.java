package com.his.admin.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.his.admin.dtos.PlanDTO;
import com.his.admin.model.PlanAccountState;
import com.his.admin.model.PlanEntity;
import com.his.admin.repository.PlanEntityRepository;
import com.his.admin.service.IPlanService;
import com.his.admin.utils.PlanMapper;

@Service
public class PlanServiceImpl implements IPlanService {
	
	private PlanEntityRepository planRepo;
	
	public PlanServiceImpl(PlanEntityRepository planRepo) {
		this.planRepo = planRepo;
	}

	@Override
	public PlanDTO savePlan(PlanDTO planDTO) {
		PlanEntity planEntity = PlanMapper.convertPlanDTOToPlanEntity(planDTO);
		planEntity.setPlanAccountState(PlanAccountState.ACTIVE);
	
		PlanEntity savedInDb = planRepo.save(planEntity);
		
		return Optional.ofNullable(savedInDb)
					   .map(PlanMapper::convertPlanEntityToPlanDTO)
					   .orElseThrow(()-> new RuntimeException("Failed To Save in DB"));
	}
	
	@Override
	public List<PlanDTO> getAllPlans() {
		return planRepo.findAll()
					   .stream()
					   .map(PlanMapper::convertPlanEntityToPlanDTO)
					   .collect(Collectors.toList());
	}
	
	@Override
	public PlanDTO editById(Long id) {
		return planRepo.findById(id)
					   .map(PlanMapper::convertPlanEntityToPlanDTO)
					   .orElseThrow(()-> new RuntimeException("Plz Provide Valid Id"));
	}
	
	@Override
	public PlanDTO updatePlan(PlanDTO planDTO) {
		PlanEntity planEntity = PlanMapper.convertPlanDTOToPlanEntity(planDTO);
		PlanEntity updatedPlan = planRepo.save(planEntity);
		return Optional.ofNullable(updatedPlan)
					   .map(PlanMapper::convertPlanEntityToPlanDTO)
					   .orElseThrow(()-> new RuntimeException("Failed To Update Plan"));
	}
	
	@Override
	public Boolean deleteById(Long id) {
		return planRepo.findById(id)
					   .map(planEnt -> {
						   planEnt.setPlanAccountState(PlanAccountState.INACTIVE);
						   return planRepo.save(planEnt);
					   }).isPresent();
	}
	
	@Override
	public Boolean activePlanById(Long id) {
		return planRepo.findById(id)
					   .map(planEnt -> {
						   planEnt.setPlanAccountState(PlanAccountState.ACTIVE);
						   return planRepo.save(planEnt);
					   }).isPresent();
	}
}
