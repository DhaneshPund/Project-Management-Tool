package com.app.dto;

import java.util.List;

import com.app.pojos.File;
import com.app.pojos.Story;
import com.app.pojos.Subtask;

public class StoryDTO {
	private Story story;
	private List<Subtask> storySubtasks;
	private List<File> storyFiles;

	public StoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public StoryDTO(Story story, List<Subtask> storySubtasks, List<File> storyFiles) {
		super();
		this.story = story;
		if (storySubtasks != null)
			this.storySubtasks = storySubtasks;
		if (storyFiles != null)
			this.storyFiles = storyFiles;
	}
	public StoryDTO(Story story) {
		super();
		this.story = story;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public List<Subtask> getStorySubtasks() {
		return storySubtasks;
	}

	public void setStorySubtasks(List<Subtask> storySubtasks) {
		this.storySubtasks = storySubtasks;
	}

	public List<File> getStoryFiles() {
		return storyFiles;
	}

	public void setStoryFiles(List<File> storyFiles) {
		this.storyFiles = storyFiles;
	}

}
