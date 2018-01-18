package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.UserRole;

@Repository("userRoleRepository")
public interface User_Role_Repository extends JpaRepository<UserRole,Serializable> {

}
