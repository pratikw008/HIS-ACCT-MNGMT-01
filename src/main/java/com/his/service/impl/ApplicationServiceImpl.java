package com.his.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.his.dtos.ApplicationDtlsDTO;
import com.his.exception.ApplicationNotFoundException;
import com.his.model.ApplicationDtlsEntity;
import com.his.model.DeleteState;
import com.his.repository.ApplicationDtlsRepository;
import com.his.service.IApplicationService;
import com.his.utils.ApplicationMapper;

@Service
public class ApplicationServiceImpl implements IApplicationService {
	
	private ApplicationDtlsRepository applRepo;
	
	private RestTemplate restTemplate;

	public ApplicationServiceImpl(ApplicationDtlsRepository applRepo, RestTemplate restTemplate) {
		super();
		this.applRepo = applRepo;
		this.restTemplate = restTemplate;
	}

	@Override
	public String saveApplicant(ApplicationDtlsDTO applicantDTO) {
		ApplicationDtlsEntity applicationEntity = ApplicationMapper.convertApplicantDTOToApplicantEntity(applicantDTO);
		applicationEntity.setDeleteState(DeleteState.ACTIVE);
		
		ResponseEntity<String> respEntity = restTemplate.getForEntity("http://localhost:2010/validate/{ssn}", String.class, applicationEntity.getSsnNo());
		return Optional.ofNullable(respEntity.getBody())
					   .filter(str -> !str.isEmpty())
					   .filter(dto -> dto.equalsIgnoreCase("Vegas"))
					   .map(dto -> {
						   ApplicationDtlsEntity savedInDb = applRepo.save(applicationEntity);
						   return "Application Registered With No::"+savedInDb.getApplicationId();
					   })
					   .orElse("Failed To Register Application. Applicant is from another State.");
	}
	
	@Override
	public Page<ApplicationDtlsDTO> findAllApplication(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<ApplicationDtlsEntity> page = applRepo.findAll(pageable);
		return page.map(ApplicationMapper::convertApplicantEntityToApplicantDTO);
	}
	
	@Override
	public ApplicationDtlsDTO editById(String id) {
		return applRepo.findById(id)
					   .map(ApplicationMapper::convertApplicantEntityToApplicantDTO)
					   .orElseThrow(()-> new ApplicationNotFoundException("Plz Provide Valid Application No:: "+id));
	}
		
	@Override
	public ApplicationDtlsDTO updateApplication(ApplicationDtlsDTO applicationDTO) {
		ApplicationDtlsEntity applicationEntity = ApplicationMapper.convertApplicantDTOToApplicantEntity(applicationDTO);
		return Optional.ofNullable(applRepo.save(applicationEntity))
					   .map(ApplicationMapper::convertApplicantEntityToApplicantDTO)
					   .orElseThrow(()-> new ApplicationNotFoundException("Failed To Update"));
	}
	
	@Override
	public Boolean deleteById(String id) {
		return applRepo.findById(id)
					   .map(ent -> {
						   	ent.setDeleteState(DeleteState.INACTIVE);
						   	return applRepo.save(ent);
					   })
					   .isPresent();
	}
	
	@Override
	public Boolean activeById(String id) {
		return applRepo.findById(id)
					   .map(ent -> {
						   ent.setDeleteState(DeleteState.ACTIVE);
						   	return applRepo.save(ent);
					   })
					   .isPresent();
	}
}