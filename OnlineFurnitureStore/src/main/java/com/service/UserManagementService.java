package com.service;

import com.entity.User;
import com.exception.UserNotFoundException;

public interface UserManagementService {
	boolean loginUser(String username,String password) throws UserNotFoundException;
	User registerNewUser(User user) throws UserNotFoundException;
	User updateUser(User user) throws UserNotFoundException;
	String deleteUser() throws UserNotFoundException;
	User deleteUserById(int uid) throws UserNotFoundException;
	User getId(int userId) throws UserNotFoundException;
}
