package com.his.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.his.admin.dtos.UserDTO;
import com.his.admin.service.IUserService;

@Controller
public class ViewAccountsController {
	
	private IUserService userService;

	public ViewAccountsController(IUserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/viewAccounts")
	public String showViewAccounts(ModelMap map) {
		map.addAttribute("roles", userService.getAllRoles());
		return "viewAccounts";
	}
	
	@GetMapping("/getUserByRole")
	@ResponseBody
	public List<UserDTO> getUserByRole(@RequestParam("role") String role) {
		return userService.findByRole(role);
						  //.stream()
						  //.collect(Collectors.toMap(UserDTO::getUserId, usrDTO->usrDTO));
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
	
	@GetMapping("/activateAcc")
	public String activateAcctById(@RequestParam("id")Long id) {
		userService.activeAccountById(id);
		return "redirect:/viewAccounts";
	}
}