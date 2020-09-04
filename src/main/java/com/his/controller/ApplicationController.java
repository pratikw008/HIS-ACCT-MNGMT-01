package com.his.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.dtos.ApplicationDtlsDTO;
import com.his.service.IApplicationService;

@Controller
public class ApplicationController {

	private IApplicationService applicationService;

	public ApplicationController(IApplicationService applicationService) {
		this.applicationService = applicationService;
	}
	
	@GetMapping("/regApplication")
	public String showApplicantRegPage(ModelMap map) {
		map.addAttribute("applicationDTO", new ApplicationDtlsDTO());
		return "applicationRegistration";
	}
	
	@PostMapping("/regApplication")
	public String regApplicant(@ModelAttribute("applicantDTO")ApplicationDtlsDTO applicantDTO, ModelMap map) {
		String message = applicationService.saveApplicant(applicantDTO);
		map.addAttribute("applicationDTO", new ApplicationDtlsDTO());
		map.addAttribute("msg", message);			
		return "applicationRegistration";
	}
	
	@GetMapping("/viewApplications")
	public String findAllByPage(@RequestParam(name = "pageNo", defaultValue = "1")int pageNo, 
								@RequestParam(name = "pageSize", defaultValue = "1")int pageSize, ModelMap map) {
		Page<ApplicationDtlsDTO> page = applicationService.findAllApplication(pageNo,pageSize);
		map.addAttribute("applicationList", page.getContent());
		map.addAttribute("totalPages", page.getTotalPages());
		map.addAttribute("hasPrev", page.hasPrevious());
		map.addAttribute("hasNext", page.hasNext());
		map.addAttribute("currentPage", page.getNumber()+1);
		map.addAttribute("pageSize", pageSize);
		return "applicationDataView";
	}
	
	@GetMapping("/editApplication")
	public String editById(@RequestParam("applicationId")String id,ModelMap map) {
		ApplicationDtlsDTO applicationDTO = applicationService.editById(id);
		map.addAttribute("applicationDTO", applicationDTO);
		return "applicationDataEdit";
	}
	
	@PostMapping("/updateApplication")
	public String updateApplication(@ModelAttribute("applicationDTO")ApplicationDtlsDTO applicationDTO) {
		applicationService.updateApplication(applicationDTO);
		return "redirect:/viewApplications";
	}
	
	@GetMapping("/deleteApplication")
	public String deleteById(@RequestParam("applicationId")String id) {
		Boolean isDeleted = applicationService.deleteById(id);
		if(isDeleted) {			
			return "redirect:/viewApplications";
		}
		return "applicationDataView";
	}
	
	@GetMapping("/activeApplication")
	public String activeById(@RequestParam("applicationId")String id) {
		Boolean isActivated = applicationService.activeById(id);
		if(isActivated) {			
			return "redirect:/viewApplications";
		}
		return "applicationDataView";
	}
}
