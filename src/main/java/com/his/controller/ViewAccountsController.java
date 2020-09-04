package com.his.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.dtos.UserDTO;
import com.his.service.IUserService;

@Controller
public class ViewAccountsController {
	
	private IUserService userService;

	public ViewAccountsController(IUserService userService) {
		this.userService = userService;
	}
	
	/*
	 * @GetMapping("/viewAccounts") public String showViewAccounts(ModelMap map) {
	 * map.addAttribute("roles", userService.getAllRoles()); return "viewAccounts";
	 * }
	 */
	
	@GetMapping("/viewAccounts")
	public String getUserByRole(@RequestParam(value = "role",defaultValue = "CASE WORKER") String role, ModelMap map) {
		System.out.println(role);
		
		List<UserDTO> listUsers = userService.findByRole(role);
		//map.addAttribute("role", role);
		map.addAttribute("roles", userService.getAllRoles());
		map.addAttribute("listUsers", listUsers);
		return "viewAccounts";
	}
	
	@GetMapping("/edit")
	public String editAccountById(@RequestParam("id")Long id,ModelMap map) {
		map.addAttribute("userDTO", userService.getUserById(id));
		map.addAttribute("roles", userService.getAllRoles());
		return "editUserAccount";
	}
	
	@PostMapping("/update")
	public String updateUserAccount(@ModelAttribute("userDTO")UserDTO userDTO, ModelMap map) {
		UserDTO updatedUser = userService.updateUser(userDTO);
		if(updatedUser != null) {
			return "redirect:/viewAccounts";
		}
		else {
			map.addAttribute("userDTO", userDTO);
			return "editUserAccount";
		}
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("id")Long id) {
		userService.deleteById(id);
		return "redirect:/viewAccounts";
	}
	
	@GetMapping("/active")
	public String activateAcctById(@RequestParam("id")Long id) {
		userService.activeAccountById(id);
		return "redirect:/viewAccounts";
	}
}