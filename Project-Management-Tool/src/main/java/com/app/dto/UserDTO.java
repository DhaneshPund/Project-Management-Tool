package com.app.dto;

import com.app.pojos.ProjectDetails;
import com.app.pojos.User;

public class UserDTO {
	private User user;
	private ProjectDetails projectDetails;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(User user, ProjectDetails projectDetails) {
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

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	
}
