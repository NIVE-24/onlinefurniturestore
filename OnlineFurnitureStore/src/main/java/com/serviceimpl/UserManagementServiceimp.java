package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.repository.UserManagementDao;
import com.service.UserManagementService;
import com.entity.User;
import com.exception.UserNotFoundException;

/**
 * Author : Priyanka N 
 * Date :17-09-2021 
 * Description:This is User Management Service Class that provide services to add a user,
 *  remove a user, update a user and to view user details
 **/
@Service
@Transactional
public class UserManagementServiceimp implements UserManagementService {

	Logger logger = Logger.getLogger(UserManagementServiceimp.class);
	@Autowired
	public UserManagementDao umd;

	/**
	 * 
	 * Description :To Check the login username and password 
	 * Input Params :Username and password 
	 * Return Value :Boolean 
	 * Exception :UserNotFoundException-It is raised when it not satisfy the constraint
	 **/
	@Override
	public boolean loginUser(String username, String password) throws UserNotFoundException {
		boolean flag = false;
		try {
			if (username == null && password == null) {
				throw new UserNotFoundException("User Details cannot be Empty");
			} else {
				flag = true;
			}
		} catch (Exception e) {
			throw new UserNotFoundException("User Details cannot be Empty");
		}

		return flag;
	}

	/**
	 * Description :To add user to the database 
	 * Input Params :User object to be added to the database 
	 * Return Value :UserDTO object 
	 * Exception : UserNotFoundException - It is raised when user already exist
	 **/

	@Override
	public User registerNewUser(User user) throws UserNotFoundException {
		Optional<User> userTemp = umd.findById(user.getUid());
		try {
			logger.info("Fetching User details inprogress...");
			if (userTemp != null) {
				user = umd.save(user);
				logger.info("Add User details: " + user);
				return user;

			} else {

				throw new UserNotFoundException("The given User already exist");
			}
		} catch (Exception e) {
			throw new UserNotFoundException("The given User is  already exist");
		}

	}

	/**
	 * 
	 * Description :To update User details to the database 
	 * Input Params :User to be updated in the database
	 *  Return Value :USerDTO object of the User been updated
	 * Exception :USerNotFoundException-It is raised when User doesn't exist
	 **/

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		Optional<User> resultUser = umd.findById(user.getUid());
		try {
			logger.info("Fetching User details inprogress....");
			if ((resultUser != null)) {

				User updateUser = umd.save(user);
				logger.info("Update User details: " + updateUser);
				return updateUser;

			} else {
				throw new UserNotFoundException("The User is already exist");

			}
		} catch (Exception e) {
			throw new UserNotFoundException("User already exist");
		}

	}

	/**
	 * Description :To delete user from the database 
	 * Input Params :User to be deleted from the database 
	 * Return Value :String 
	 * Exception :UserNotFoundException-It is raised when there is no values in the user
	 **/

	@Override
	public String deleteUser() throws UserNotFoundException {
		List<User> resultUser = new ArrayList<User>();
		try {
			logger.info("User inprogress...");
			resultUser = umd.findAll();
			if (resultUser != null) {
				umd.deleteAll();
				logger.info("DeletedSuccessfully");
				return "Deleted successfully";
			} else {
				throw new UserNotFoundException("There is no values in user table");
			}

		} catch (Exception e) {
			throw new UserNotFoundException("There is no values in the user table");
		}
	}

	/**
	 * Description :To delete user from the database 
	 * Input Params :User id to be deleted from the database
	 *  Return Value :UserDTO object of the User been deleted 
	 *  Exception :USerNotFoundException-It is raised when User ID doesn't exist
	 **/

	@Override
	public User deleteUserById(int uid) throws UserNotFoundException {
		Optional<User> del = umd.findById(uid);
		logger.info("Fetching User inprogress...");
		if (del == null) {
			throw new UserNotFoundException("No user found");
		}

		else {
			umd.deleteById(uid);
			if (del.isPresent()) {
				logger.info("User details: " + del.get());
				return del.get();
			} else {
				throw new UserNotFoundException("Not Present");
			}

		}
	}

	/**
	 * Description :To fetch User details from the database 
	 * Input Params :User ID object to be fetched from the database 
	 * Return Value :UserDTO object of the User been fetched 
	 * Exception :USerNotFoundException-It is raised when user Id doesn't exist
	 **/

	@Override
	public User getId(int userId) throws UserNotFoundException {
		Optional<User> getUser = umd.findById(userId);
		logger.info("Fetching User inprogress...");
		if (getUser == null) {
			throw new UserNotFoundException("User not found");
		} else {
			User getUserId = umd.findById(userId).orElse(null);
			logger.info("User details: " + getUserId);
			return getUserId;
		}
	}

}
