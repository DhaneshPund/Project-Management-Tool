package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ProjectDetails;
import com.app.pojos.User;

public interface ProjectRepository extends JpaRepository<ProjectDetails, String> {

	Optional<ProjectDetails> findByProjectName(String projectName);

	Optional<List<ProjectDetails>> findByUser(User user);


}
