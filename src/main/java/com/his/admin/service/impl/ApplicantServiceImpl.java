package com.his.admin.service.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.his.admin.dtos.ApplicantDtlsDTO;
import com.his.admin.model.ApplicantDtlsEntity;
import com.his.admin.repository.ApplicantDtlsRepository;
import com.his.admin.service.IApplicantService;
import com.his.admin.utils.ApplicantMapper;

@Service
public class ApplicantServiceImpl implements IApplicantService {
	
	private ApplicantDtlsRepository applicantRepo;
	
	private RestTemplate restTemplate;

	public ApplicantServiceImpl(ApplicantDtlsRepository applicantRepo, RestTemplate restTemplate) {
		this.applicantRepo = applicantRepo;
		this.restTemplate = restTemplate;
	}


	@Override
	public String saveApplicant(ApplicantDtlsDTO applicantDTO) {
		ApplicantDtlsEntity applicantEntity = ApplicantMapper.convertApplicantDTOToApplicantEntity(applicantDTO);
		
		ResponseEntity<String> respEntity = restTemplate.getForEntity("http://localhost:2010/validate/{ssn}", String.class, applicantEntity.getSsnNo());
		return Optional.ofNullable(respEntity.getBody())
					   .filter(str -> !str.isEmpty())
					   .filter(dto -> dto.equalsIgnoreCase("Vegas"))
					   .map(dto -> {
						   ApplicantDtlsEntity savedInDb = applicantRepo.save(applicantEntity);
						   return "Applicant Registered With No::"+savedInDb.getApplicantId();
					   })
					   .orElse("Failed To Register Applicant. Applicant is from another State.");
		}
}