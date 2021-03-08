package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, String> {

	@Query("select u from User u left outer join fetch u.userProject where u.email= :email and u.password= :password")
	Optional<User> authenticateUser(@Param("email") String email, @Param("password") String password);

}
