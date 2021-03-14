package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ProjectHandlingException;
import com.app.custom_exceptions.StoryHandlingException;
import com.app.dao.ProjectRepository;
import com.app.dao.StoryRepository;
import com.app.pojos.ProjectDetails;
import com.app.pojos.Story;
import com.app.pojos.Subtask;

@Service
@Transactional
public class StoryServiceImpl implements IStoryService {
	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private ProjectRepository projectRepository;


	@Override
	public Story addStory(Story story, int projectId) {
		ProjectDetails project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied id"));
		story.setStoryProject(project);
		return storyRepository.save(story);
	}

	@Override
	public void deleteStory(int sid) {
		storyRepository.findById(sid).orElseThrow(() -> new StoryHandlingException("No story exist with supplied id"));
		storyRepository.deleteById(sid);
	}

	@Override
	public List<Story> getStoriesByProjectId(int projectId) {
		// TODO Auto-generated method stub
		ProjectDetails project = projectRepository.findById(projectId)
				.orElseThrow(() -> new ProjectHandlingException("No Project exist with supplied name"));
		return storyRepository.findStoryByProjectId(project);
	}

	@Override
	public Story updateStory(Story updatedStory, int storyId) {
		Story story = storyRepository.fetchStoryWithSubtask(storyId)
				.orElseThrow(() -> new StoryHandlingException("No story exist with supplied id"));
		story.setStoryDescription(updatedStory.getStoryDescription());
		story.setStoryName(updatedStory.getStoryName());
		story.setStoryPoints(updatedStory.getStoryPoints());
		story.setStoryPriority(updatedStory.getStoryPriority());
		story.setStoryStatus(updatedStory.getStoryStatus());
		story.setStoryDueDate(updatedStory.getStoryDueDate());
		return story;
	}

	@Override
	public Story addSubTask(Subtask subtask, int storyId) {
		Story story = storyRepository.findById(storyId)
				.orElseThrow(() -> new StoryHandlingException("No story exist with supplied id"));
		story.addSubtask(subtask);
		return story;
	}

	@Override
	public List<Subtask> getStorySubtasks(Story story) {
		Story s = storyRepository.fetchStoryWithSubtask(story.getSid()).orElse(null);
		if (s != null)
			return s.getStorySubtasks();
		return null;
	}

}
