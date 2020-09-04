package com.his.service;

import org.springframework.data.domain.Page;

import com.his.dtos.ApplicationDtlsDTO;

public interface IApplicationService {
	
	public String saveApplicant(ApplicationDtlsDTO applicantDTO);
	
	public Page<ApplicationDtlsDTO> findAllApplication(int pageNo, int pageSize);
	
	public ApplicationDtlsDTO editById(String id);
	
	public ApplicationDtlsDTO updateApplication(ApplicationDtlsDTO applicationDTO);
	
	public Boolean deleteById(String id);
	
	public Boolean activeById(String id);
}
