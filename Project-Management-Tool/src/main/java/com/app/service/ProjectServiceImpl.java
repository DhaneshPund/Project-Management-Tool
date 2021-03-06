package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProjectHandlingException;
import com.app.dao.ProjectRepository;
import com.app.pojos.ProjectDetails;
import com.app.pojos.User;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Override
	public ProjectDetails createNewProject(ProjectDetails project) {
		if (projectRepository.findById(project.getUniquePid()).isPresent())
			throw new ProjectHandlingException("Duplicate entry for existing project id or name");
		else
			return projectRepository.save(project);

	}

	@Override
	public void deleteProject(String pid) {
		ProjectDetails project = projectRepository.findById(pid)
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied name"));
		projectRepository.delete(project);

	}

	@Override
	public ProjectDetails updateProjectDetails(ProjectDetails p) {
		ProjectDetails project = projectRepository.findById(p.getUniquePid())
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied name"));
		project.setProjectDescription(p.getProjectDescription());
		project.setProjectStartDate(p.getProjectStartDate());
		project.setProjectEndDate(p.getProjectEndDate());
		return project;
	}

	@Override
	public List<ProjectDetails> getUserProjects(User user) {
		// TODO Auto-generated method stub
		List<ProjectDetails> projectList = projectRepository.findByUser(user)
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied id"));
		return projectList;
	}

	@Override
	public List<ProjectDetails> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public ProjectDetails getProject(String uniquePid) {
		ProjectDetails project = projectRepository.findById(uniquePid)
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied name"));
		return project;
	}

}
