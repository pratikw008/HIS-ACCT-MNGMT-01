package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
