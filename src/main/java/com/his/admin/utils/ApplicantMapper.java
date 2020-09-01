package com.his.admin.utils;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.his.admin.dtos.ApplicantDtlsDTO;
import com.his.admin.model.ApplicantDtlsEntity;

public class ApplicantMapper {
	
	public static ApplicantDtlsEntity convertApplicantDTOToApplicantEntity(ApplicantDtlsDTO applicantDTO) {
		return Optional.ofNullable(applicantDTO)
					   .map(dto -> {
						   ApplicantDtlsEntity dtlsEntity = new ApplicantDtlsEntity();
						   BeanUtils.copyProperties(dto, dtlsEntity);
						   return dtlsEntity;
					   })
					   .orElseThrow(()-> new RuntimeException("Plz Provide Valid ApplicantDtlsDTO"));
	}
	
	public static ApplicantDtlsDTO convertApplicantEntityToApplicantDTO(ApplicantDtlsEntity entity) {
		return Optional.ofNullable(entity)
					   .map(ent -> {
						   ApplicantDtlsDTO applicantDtlsDTO = new ApplicantDtlsDTO();
						   BeanUtils.copyProperties(ent, applicantDtlsDTO);
						   return applicantDtlsDTO;
					   })
					   .orElseThrow(()-> new RuntimeException("Plz Provide Valid ApplicantDtlsEntity"));
	}
}