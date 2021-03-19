package com.app.service;

import java.util.List;

import com.app.pojos.ProjectDetails;
import com.app.pojos.User;

public interface IProjectService {
	ProjectDetails createNewProject(ProjectDetails project);
	void deleteProject(String pid);
	ProjectDetails updateProjectDetails(ProjectDetails project);
	List<ProjectDetails> getUserProjects(User user);
	List<ProjectDetails> getAllProjects();
	ProjectDetails getProject(String uniquePid);
}
