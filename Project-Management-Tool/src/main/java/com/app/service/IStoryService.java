package com.app.service;

import java.util.List;

import com.app.dto.StoryDTO;
import com.app.pojos.Story;
import com.app.pojos.Subtask;

public interface IStoryService {
	Story addStory(Story story, String uniquePid);
	void deleteStory(int sid);
	List<Story> getStoriesByProjectId(String uniquePid);
	Story updateStory(Story story, int storyId);
	Story addSubTask(Subtask subtask, int storyId);
	List<Subtask> getStorySubtasks(Story story);
}
