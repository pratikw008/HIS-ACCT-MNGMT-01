package com.his.admin.utils;

import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.his.admin.dtos.UserDTO;
import com.his.admin.model.UserEntity;

public class UserMapper {
	
	public static UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
		return Optional.ofNullable(userEntity)
					   .map(usrEnt -> {
						   UserDTO userDTO = new UserDTO();
						   BeanUtils.copyProperties(usrEnt, userDTO);
						   return userDTO;
					   })
					   .orElseThrow(() -> new RuntimeException("Plz Provide UserEntity"));
	}
	
	public static UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
		return Optional.ofNullable(userDTO)
					   .map(usrDto -> {
						   UserEntity userEntity = new UserEntity();
						   BeanUtils.copyProperties(usrDto, userEntity);
						   return userEntity;
					   })
					   .orElseThrow(() -> new RuntimeException("Plz Provide UserDTO"));
	}
}