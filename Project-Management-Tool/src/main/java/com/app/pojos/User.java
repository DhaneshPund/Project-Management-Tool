package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
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
	@JsonIgnore
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(name="user_role",length =20)
	private Role userRole;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	@JsonIgnore
	private List<ProjectDetails> userProjects;
	
	public User() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public User(String name, String email, String password, Role userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
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
				+ ", userRole=" + userRole + "]";
	}

	public List<ProjectDetails> getUserProjects() {
		return userProjects;
	}

	public void setUserProjects(List<ProjectDetails> userProjects) {
		this.userProjects = userProjects;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	//helper methods
	public void addProject(ProjectDetails project)
	{
		userProjects.add(project);
	}
	public void removeProject(ProjectDetails project)
	{
		userProjects.remove(project);
	}
	
}
