package com.his.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.admin.dtos.UserDTO;
import com.his.admin.model.UnlockAccount;
import com.his.admin.service.IUserService;

@Controller
public class UnlockAccountController {
	
	private IUserService userService;

	public UnlockAccountController(IUserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/unlockAcc")
	public String showUnlockAccount(@RequestParam("email")String email,ModelMap map) {
		UnlockAccount unlockAccount = UnlockAccount.builder().email(email).build();
		map.addAttribute("unlockAccount", unlockAccount);
		return "unlockUserAccount";
	}
	
	@PostMapping("/unlockAcc")
	public String unlockAccount(@ModelAttribute("unlockAccount")UnlockAccount unlockAccount,ModelMap map) {
		UserDTO userDTO = userService.unlockUserAcctEmailAndPazzword(unlockAccount);
		UserDTO updateUser = userService.updateUser(userDTO);
		if(updateUser != null) {			
			return "unlockUserAcctSuccess";
		}
		else {
			map.addAttribute("error", "Failed To Unlock Your Account");
			map.addAttribute("unlockAccount", UnlockAccount.builder().email(unlockAccount.getEmail()).build());
			return "unlockUserAccount";
		}
	}
}
