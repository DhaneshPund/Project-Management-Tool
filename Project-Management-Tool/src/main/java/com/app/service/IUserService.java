package com.app.service;

import com.app.pojos.User;

public interface IUserService {
	User authenticateUser(String email,String password);
	User registerUser(User transientUser);
	void deleteUser(User user);
	User updateUserPassword(String email,String oldPassword,String newPassword);
}
