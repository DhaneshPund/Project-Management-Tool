package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ProjectDetails;
import com.app.service.IProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private IProjectService projectService;
	
	public ProjectController() {
	System.out.println("in ctor of "+getClass().getName());
	}
	
	@PostMapping("create")
	public ResponseEntity<?> createProject(@RequestBody ProjectDetails projectDetails) {
		System.out.println("in create project "+projectDetails);
		return ResponseEntity.ok(projectService.createNewProject(projectDetails));
	}
	
	@PutMapping("update")
	public ResponseEntity<?> updateProject(@RequestBody ProjectDetails projectDetails) {
		System.out.println("in update project details "+projectDetails);
		return ResponseEntity.ok(projectService.updateProjectDetails(projectDetails));
	}
	
	@DeleteMapping("delete/{projectName}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectName) {
		System.out.println("in delete project "+projectName);
		projectService.deleteProject(projectName);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
