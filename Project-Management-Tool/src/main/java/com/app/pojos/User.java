package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
	@Column(length =20)
	private String name;
	@Column(unique = true)
	private String email;
	@Column(length = 20)
	private String password;
	@Column(length = 20,name = "confirm_password")
	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	@Column(name="user_role",length =20)
	private Role userRole;
	@ManyToOne
	@JoinColumn(name = "pid")
	@JsonIgnoreProperties("users")
	@JsonIgnore
	private ProjectDetails userProject;
	
	public User() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public User(String name, String email, String password, String confirmPassword, Role userRole,
			ProjectDetails userProject) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.userProject = userProject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", userRole=" + userRole + "]";
	}

	public ProjectDetails getUserProject() {
		return userProject;
	}

	public void setUserProject(ProjectDetails userProject) {
		this.userProject = userProject;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
	
}
