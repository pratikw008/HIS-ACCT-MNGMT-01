package com.his.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.admin.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
