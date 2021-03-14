package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.ProjectDetails;
import com.app.pojos.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>{
	@Query("select s from Story s join fetch s.storySubtasks where s.storyProject=:project")
	List<Story> findStoryByProjectId(@Param("project") ProjectDetails project);
	@Query("select s from Story s join fetch s.storySubtasks where s.sid=:storyId")
	Optional<Story> fetchStoryWithSubtask(@Param("storyId") int storyId);
}
//Optional<Customer> fetchDetailsCustomerIdAndPassword(@Param("id") long custId, @Param("pass") String pwd);
