package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dao.UserRepository;
import com.app.pojos.Role;
import com.app.pojos.User;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAllUsers(Role.ADMIN);
	}
	
	
	@Override
	public User authenticateAdmin(String email,String password) {
		return userRepository.findByEmailAndPassword(email, password,Role.ADMIN)
		.orElseThrow(()->new UserHandlingException("Invalid admin credentials"));
	}
	@Override
	public User authenticateUser(String email, String password) {
		return userRepository.authenticateUser(email, password).orElseThrow
				(()->new UserHandlingException("Invalid credentials!!!!"));
	}

	@Override
	public User registerUser(User transientUser) {
	try {
		return userRepository.save(transientUser);		
		} catch (Exception e) {
			throw new UserHandlingException("Duplicate entry on same email");
		}
	}

	@Override
	public void deleteUser(int userId) {
		 userRepository.deleteById(userId);
	}


	@Override
	public User updateUserPassword(String email, String oldPassword, String newPassword) {
		User user = userRepository.authenticateUser(email, oldPassword)
				.orElseThrow (()->new UserHandlingException("No such User Exists"));
				user.setPassword(newPassword);
		return user;
	}


	@Override
	public User updateUserRole(User u) {
		User user = userRepository.findById(u.getId())
		.orElseThrow (()->new UserHandlingException("No such User Exists"));
		user.setUserRole(u.getUserRole());
		return user;
	}

	

}
