package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.UserHandlingException;
import com.app.dao.UserRepository;
import com.app.pojos.User;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	@Override
	public User authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.authenticateUser(email, password);
		return user.orElseThrow
				(()->new UserHandlingException("Invalid credentials!!!!"));
	}

	@Override
	public User registerUser(User transientUser) {
		// TODO Auto-generated method stub
	try {
		return userRepository.save(transientUser);		
		} catch (Exception e) {
			throw new UserHandlingException("Duplicate entry on same email");
		}
	}

	@Override
	public void deleteUser(User user) {
		 userRepository.delete(user);
	}


	@Override
	public User updateUserPassword(String email, String oldPassword, String newPassword) {
		User user = userRepository.authenticateUser(email, oldPassword).orElseThrow
				(()->new UserHandlingException("No such User Exists"));
				user.setPassword(newPassword);
		return user;
	}

}
