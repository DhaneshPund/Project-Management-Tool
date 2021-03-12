package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProjectHandlingException;
import com.app.dao.ProjectRepository;
import com.app.pojos.ProjectDetails;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public ProjectDetails createNewProject(ProjectDetails project) {
		try {
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectHandlingException("Duplicate entry for existing project name");
		}
	}

	@Override
	public void deleteProject(String projectName) {
		ProjectDetails project = projectRepository.findByProjectName(projectName)
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied name"));
		projectRepository.delete(project);

	}

	@Override
	public ProjectDetails updateProjectDetails(ProjectDetails p) {
		ProjectDetails project = projectRepository.findByProjectName(p.getProjectName())
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied name"));
		project.setProjectDescription(p.getProjectDescription());
		project.setProjectStartDate(p.getProjectStartDate());
		project.setProjectEndDate(p.getProjectEndDate());
		return project;
	}

}
