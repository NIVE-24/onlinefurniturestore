package com.repository;

import org.springframework.stereotype.Repository;

import com.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserManagementDao extends JpaRepository<User, Integer> {

}
