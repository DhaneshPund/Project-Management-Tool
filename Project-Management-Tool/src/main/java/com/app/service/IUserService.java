package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	User authenticateUser(String email,String password);
	User registerUser(User transientUser);
	void deleteUser(int userId);
	User updateUserPassword(String email,String oldPassword,String newPassword);
	List<User> getAllUsers();
	User authenticateAdmin(String email,String password);
	User updateUserRole(User user);
}
