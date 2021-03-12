package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ProjectDetails;

public interface ProjectRepository extends JpaRepository<ProjectDetails, Integer> {

	Optional<ProjectDetails> findByProjectName(String projectName);


}
