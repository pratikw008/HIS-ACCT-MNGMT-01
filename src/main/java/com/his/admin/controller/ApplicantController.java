package com.his.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.his.admin.dtos.ApplicantDtlsDTO;
import com.his.admin.service.IApplicantService;

@Controller
public class ApplicantController {

	private IApplicantService applicantService;

	public ApplicantController(IApplicantService applicantService) {
		this.applicantService = applicantService;
	}
	
	@GetMapping("/regApplicant")
	public String showApplicantRegPage(ModelMap map) {
		map.addAttribute("applicantDTO", new ApplicantDtlsDTO());
		return "applicantRegistration";
	}
	
	@PostMapping("/regApplicant")
	public String regApplicant(@ModelAttribute("applicantDTO")ApplicantDtlsDTO applicantDTO, ModelMap map) {
		String message = applicantService.saveApplicant(applicantDTO);
		map.addAttribute("applicantDTO", new ApplicantDtlsDTO());
		map.addAttribute("msg", message);			
		return "applicantRegistration";
	}
}
