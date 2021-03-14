package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u left outer join fetch u.userProjects where u.email= :email and u.password= :password")
	Optional<User> authenticateUser(@Param("email") String email, @Param("password") String password);

	@Query("select u from User u where u.email=:email and u.password=:password and u.userRole=:userRole")
	Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password,@Param("userRole") Role userRole);

	@Query("select u from User u where u.userRole!=:userRole")
	List<User> findAllUsers(@Param("userRole") Role userRole);

}
