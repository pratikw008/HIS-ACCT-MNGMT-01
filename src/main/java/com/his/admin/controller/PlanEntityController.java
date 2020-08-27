package com.his.admin.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.admin.dtos.PlanDTO;
import com.his.admin.service.IPlanService;

@Controller
public class PlanEntityController {
	
	private IPlanService planService;

	public PlanEntityController(IPlanService planService) {
		this.planService = planService;
	}
	
	@GetMapping("/createPlan")
	public String showcreatePlanPage(ModelMap map) {
		map.addAttribute("planDTO", new PlanDTO());
		return "planRegistration"; 
	}
	
	@PostMapping("/createPlan")
	public String createPlan(@ModelAttribute("planDTO")PlanDTO planDTO,ModelMap map) {
		PlanDTO savedPlan = planService.savePlan(planDTO);
		if(savedPlan != null) {
			map.addAttribute("message", "Plan Created Successfully");
			map.addAttribute("planDTO", new PlanDTO());
			return "planRegistration";
		}
		else {			
			map.addAttribute("planDTO", new PlanDTO());
			return "planRegistration";
		}
	}
	
	@GetMapping("/viewPlans")
	public String getAllPlans(ModelMap map){
		List<PlanDTO> allPlans = planService.getAllPlans();
		if(allPlans.isEmpty()) {
			map.addAttribute("message", "No Plans Available");
			return "planDataView";
		}
		map.addAttribute("listPlans", allPlans);
		return "planDataView";
	}
	
	@GetMapping("/viewPlansPaging")
	public String getAllPlansWithPagingAndSorting(@RequestParam("pageNo")int pageNo,@RequestParam("pageSize")int pageSize,ModelMap map){
		Page<PlanDTO> page = planService.getAllPlansWithPaginationAndSorting(pageNo, pageSize);
		map.addAttribute("listPlans", page.getContent());
		map.addAttribute("totalPages", page.getTotalPages());
		map.addAttribute("hasNext", page.hasNext());
		map.addAttribute("hasPrevious", page.hasPrevious());
		map.addAttribute("currentPage", page.getNumber());
		return "planDataView";
	}
	
	@GetMapping("/editPlan")
	public String editById(@RequestParam("id")Long id,ModelMap map) {
		PlanDTO planDTO = planService.editById(id);
		map.addAttribute("planDTO", planDTO);
		return "planDataEdit";
	}
	
	@PostMapping("/updatePlan")
	public String updatePlan(@ModelAttribute("planDTO")PlanDTO planDTO,ModelMap map) {
		PlanDTO updatedPlan = planService.updatePlan(planDTO);
		if(updatedPlan != null) {
			return "redirect:/viewPlans";
		}
		else {
			map.addAttribute("planDTO", planDTO);
			return "planDataEdit";
		}
	}
	
	@GetMapping("/deletePlan")
	public String deleteById(@RequestParam("id")Long id) {
		Boolean isDeleted = planService.deleteById(id);
		if(isDeleted) {
			return "redirect:/viewPlans";			
		}
		return "planDataView";
	}
	
	@GetMapping("/activePlan")
	public String activePlanById(@RequestParam("id")Long id) {
		Boolean isActivated = planService.activePlanById(id);
		if(isActivated) {
			return "redirect:/viewPlans";						
		}
		return "planDataView";		
	}
}