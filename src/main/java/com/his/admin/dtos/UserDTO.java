package com.his.admin.dtos;

import com.his.admin.model.AccountState;
import com.his.admin.model.AccountStatus;
import com.his.admin.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Long userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String pazzword;
	
	private Gender gender;
	
	private String role;
	
	private AccountStatus accountStatus;
	
	private AccountState accountState;
}