package com.his.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.admin.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {
	public List<UserEntity> findByRole(String role);
	
	public UserEntity findByEmail(String email);
	
	public UserEntity findByEmailAndPazzword(String email,String pazzword);

}