package com.his.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.admin.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public List<UserEntity> findByRole_Name(String name);
	
	public UserEntity findByEmail(String email);
	
	public UserEntity findByEmailAndPazzword(String email,String pazzword);
	
}
