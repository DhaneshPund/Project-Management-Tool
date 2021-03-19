package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.ProjectDetails;
import com.app.pojos.User;
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
	
	@DeleteMapping("delete/{pid}")
	public ResponseEntity<?> deleteProject(@PathVariable String pid) {
		System.out.println("in delete project "+pid);
		projectService.deleteProject(pid);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("getUserProjects")
	public ResponseEntity<?> getUserProjects(@RequestBody User user){
		System.out.println("in get user project for user "+user);
		return ResponseEntity.ok(projectService.getUserProjects(user));
	}
	
	@GetMapping("getAllProjects")
	public ResponseEntity<?> getAllProjects(){
		System.out.println("in get all projects");
		return ResponseEntity.ok(projectService.getAllProjects());
	}
	
}
