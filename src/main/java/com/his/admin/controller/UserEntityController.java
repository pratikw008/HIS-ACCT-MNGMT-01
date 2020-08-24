package com.his.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.his.admin.dtos.UserDTO;
import com.his.admin.service.IUserService;

@Controller
public class UserEntityController {

	private IUserService userService;

	public UserEntityController(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/createUser")
	public String showCreateUserPage(ModelMap map) {
		map.addAttribute("userDTO", new UserDTO());
		map.addAttribute("roles",userService.getAllRoles());
		return "userRegistration";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("userDTO")UserDTO userDTO,ModelMap map) {
		Boolean isSaved = userService.saveUser(userDTO);
		
		if(isSaved)
			return "userAcctSuccess";
		else
			return "redirect:/createUser";
	}
}