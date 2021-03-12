package com.app.dto;

import java.util.List;

import com.app.pojos.ProjectDetails;
import com.app.pojos.User;

public class UserDTO {
	private User user;
	private List<ProjectDetails> projectDetails;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(User user, List<ProjectDetails> projectDetails) {
		super();
		this.user=user;
		this.projectDetails=projectDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProjectDetails> getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List<ProjectDetails> projectDetails) {
		this.projectDetails = projectDetails;
	}

	
}
