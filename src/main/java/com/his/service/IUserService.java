package com.his.service;

import java.util.List;

import com.his.dtos.UserDTO;
import com.his.model.Role;
import com.his.model.UnlockAccount;

public interface IUserService {
	
	public Boolean saveUser(UserDTO userDTO);
	
	public List<UserDTO> findByRole(String role);
	
	public UserDTO findByEmail(String email);
	
	public UserDTO unlockUserAcctEmailAndPazzword(UnlockAccount unlockAccount);
	
	public UserDTO updateUser(UserDTO userDTO);
	
	public UserDTO getUserById(Long id);
	
	public void deleteById(Long id);	
	
	public void activeAccountById(Long id);	
	
	public List<Role> getAllRoles();
}
