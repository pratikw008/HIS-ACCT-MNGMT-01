package com.his.dtos;

import com.his.model.DeleteState;
import com.his.model.AccountStatus;
import com.his.model.Gender;
import com.his.model.Role;

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
	
	private Role role;
	
	private AccountStatus accountStatus;
	
	private DeleteState deleteState;
}