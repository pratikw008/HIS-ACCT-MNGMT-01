package com.his.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.his.dtos.UserDTO;
import com.his.model.DeleteState;
import com.his.model.AccountStatus;
import com.his.model.Role;
import com.his.model.UnlockAccount;
import com.his.model.UserEntity;
import com.his.repository.RoleRepository;
import com.his.repository.UserRepository;
import com.his.service.IUserService;
import com.his.utils.EmailUtils;
import com.his.utils.PasswordGenerator;
import com.his.utils.UserMapper;

@Service
public class UserServiceImpl implements IUserService {
	
	private UserRepository userRepo;
	
	private RoleRepository roleRepo;
	
	private EmailUtils emailUtils;

	public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo, EmailUtils emailUtils) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.emailUtils = emailUtils;
	}

	@Override
	public Boolean saveUser(UserDTO userDTO) {
		UserEntity userEntity = UserMapper.convertUserDTOToUserEntity(userDTO);
		userEntity.setPazzword(PasswordGenerator.generateRandomPassword(5));
		userEntity.setAccountStatus(AccountStatus.LOCKED);
		userEntity.setDeleteState(DeleteState.ACTIVE);
		
		UserEntity savedInDb = userRepo.save(userEntity);
		
		return Optional.ofNullable(savedInDb)
					   .map(usrEnt -> {
						   UserDTO savedDTO = UserMapper.convertUserEntityToUserDTO(savedInDb);
						   return emailUtils.sendUnlockAccountMail(savedDTO);
					   })
					   .orElseThrow(() -> new RuntimeException("Failed To Send Email"));
	}
	
	@Override
	public List<UserDTO> findByRole(String role) {
		return userRepo.findByRole_Name(role)
					   .stream()
					   .map(UserMapper::convertUserEntityToUserDTO)
					   .collect(Collectors.toList()); 
	}
	
	@Override
	public UserDTO findByEmail(String email) {
		UserEntity usrEntFromDb = userRepo.findByEmail(email);
		return Optional.ofNullable(usrEntFromDb)
					   .map(UserMapper::convertUserEntityToUserDTO)
					   .orElseThrow(()-> new RuntimeException("Plz Provide Valid Email"));
	}
	
	@Override
	public UserDTO unlockUserAcctEmailAndPazzword(UnlockAccount unlockAccount) {
		UserEntity fromDb = userRepo.findByEmailAndPazzword(unlockAccount.getEmail(), unlockAccount.getTempPwd());
		return Optional.ofNullable(fromDb)
					   .map(usrEnt -> {
						   usrEnt.setAccountStatus(AccountStatus.UNLOCKED);
						   usrEnt.setPazzword(unlockAccount.getNewPwd());
						   return UserMapper.convertUserEntityToUserDTO(usrEnt);
					   })
					   .orElseThrow(() -> new RuntimeException("Invalid Credentials"));
	}
	
	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		UserEntity userEntity = UserMapper.convertUserDTOToUserEntity(userDTO);
		UserEntity updatedUser = userRepo.save(userEntity);
		return Optional.ofNullable(updatedUser)
				.map(UserMapper::convertUserEntityToUserDTO)
				.orElseThrow(()-> new RuntimeException("Failed To Update"));
		
	}
	
	@Override
	public UserDTO getUserById(Long id) {
		return userRepo.findById(id)
					   .map(UserMapper::convertUserEntityToUserDTO)
					   .orElseThrow(()-> new RuntimeException("User Not Found"));
	}
	
	@Override
	public void deleteById(Long id) {
		userRepo.findById(id)
				.map(usrEnt -> {
					usrEnt.setDeleteState(DeleteState.INACTIVE);
					return userRepo.save(usrEnt);
				})
				.orElseThrow(()-> new RuntimeException("User Not Found With Id::"+id));
	}
	
	@Override
	public void activeAccountById(Long id) {
		userRepo.findById(id)
				.map(usrEnt -> {
					usrEnt.setDeleteState(DeleteState.ACTIVE);
					return userRepo.save(usrEnt);
				})
				.orElseThrow(()-> new RuntimeException("User Not Found With Id::"+id));
	}
	
	@Override
	public List<Role> getAllRoles() {
		return roleRepo.findAll();
					   //.stream()
					   //.map(role -> role.getName())
					   //.collect(Collectors.toList());
	}
}