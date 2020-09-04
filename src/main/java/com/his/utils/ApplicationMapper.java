package com.his.utils;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.his.dtos.ApplicationDtlsDTO;
import com.his.model.ApplicationDtlsEntity;

public class ApplicationMapper {
	
	public static ApplicationDtlsEntity convertApplicantDTOToApplicantEntity(ApplicationDtlsDTO applicantDTO) {
		return Optional.ofNullable(applicantDTO)
					   .map(dto -> {
						   ApplicationDtlsEntity dtlsEntity = new ApplicationDtlsEntity();
						   BeanUtils.copyProperties(dto, dtlsEntity);
						   return dtlsEntity;
					   })
					   .orElseThrow(()-> new RuntimeException("Plz Provide Valid ApplicantDtlsDTO"));
	}
	
	public static ApplicationDtlsDTO convertApplicantEntityToApplicantDTO(ApplicationDtlsEntity entity) {
		return Optional.ofNullable(entity)
					   .map(ent -> {
						   ApplicationDtlsDTO applicationDtlsDTO = new ApplicationDtlsDTO();
						   BeanUtils.copyProperties(ent, applicationDtlsDTO);
						   return applicationDtlsDTO;
					   })
					   .orElseThrow(()-> new RuntimeException("Plz Provide Valid ApplicantDtlsEntity"));
	}
}