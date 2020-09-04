package com.his.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.his.dtos.PlanDTO;
import com.his.model.DeleteState;
import com.his.model.PlanEntity;
import com.his.repository.PlanEntityRepository;
import com.his.service.IPlanService;
import com.his.utils.PlanMapper;

@Service
public class PlanServiceImpl implements IPlanService {
	
	private PlanEntityRepository planRepo;
	
	public PlanServiceImpl(PlanEntityRepository planRepo) {
		this.planRepo = planRepo;
	}

	@Override
	public PlanDTO savePlan(PlanDTO planDTO) {
		PlanEntity planEntity = PlanMapper.convertPlanDTOToPlanEntity(planDTO);
		planEntity.setDeleteState(DeleteState.ACTIVE);
	
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
	public Page<PlanDTO> getAllPlansWithPaginationAndSorting(int pageNo, int pageSize) {
		//Create Pageable using pageNo and pageSize
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return planRepo.findAll(pageable)
					   .map(PlanMapper::convertPlanEntityToPlanDTO);
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
						   planEnt.setDeleteState(DeleteState.INACTIVE);
						   return planRepo.save(planEnt);
					   }).isPresent();
	}
	
	@Override
	public Boolean activePlanById(Long id) {
		return planRepo.findById(id)
					   .map(planEnt -> {
						   planEnt.setDeleteState(DeleteState.ACTIVE);
						   return planRepo.save(planEnt);
					   }).isPresent();
	}
}
