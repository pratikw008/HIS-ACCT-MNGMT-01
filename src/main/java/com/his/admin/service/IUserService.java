package com.his.admin.service;

import java.util.List;

import com.his.admin.dtos.UserDTO;
import com.his.admin.model.Role;
import com.his.admin.model.UnlockAccount;

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
