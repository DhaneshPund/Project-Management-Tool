package com.app.service;

import com.app.pojos.ProjectDetails;

public interface IProjectService {
	ProjectDetails createNewProject(ProjectDetails project);
	void deleteProject(String projectName);
	ProjectDetails updateProjectDetails(ProjectDetails project);
}
