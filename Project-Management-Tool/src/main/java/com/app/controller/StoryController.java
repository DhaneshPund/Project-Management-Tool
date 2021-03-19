package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StoryDTO;
import com.app.pojos.Story;
import com.app.pojos.Subtask;
import com.app.service.IStoryService;

@RestController
@RequestMapping("/story")
@CrossOrigin
public class StoryController {
	@Autowired
	private IStoryService storyService;

	public StoryController() {
		System.out.println("in ctor of " + getClass().getName() + " " + storyService);
	}

	@GetMapping("get/{uniquePid}")
	public ResponseEntity<?> getProjectSepcificStories(@PathVariable String uniquePid) {
		System.out.println("in get stories by project " + uniquePid);
		List<Story> storyList = storyService.getStoriesByProjectId(uniquePid);
		List<StoryDTO> listStoryDTO = new ArrayList<StoryDTO>();
		for (Story story : storyList) {
			listStoryDTO.add(new StoryDTO(story, story.getStorySubtasks()));
		}
		return new ResponseEntity<>(listStoryDTO, HttpStatus.OK);
	}
	 
	@PostMapping("add/{projectId}")
	public ResponseEntity<?> addStory(@RequestBody Story story, @PathVariable String uniquePid) {
		System.out.println("in add story details " + story);
		Story addedStory = storyService.addStory(story, uniquePid);
		return new ResponseEntity<>(new StoryDTO(addedStory), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{storyId}")
	public ResponseEntity<?> deleteStory(@PathVariable int storyId) {
		System.out.println("in delete Story detail" + storyId);
		storyService.deleteStory(storyId);
		return ResponseEntity.ok(HttpStatus.OK);
	}


	@PutMapping("update/{storyId}")
	public ResponseEntity<?> updateStory(@RequestBody Story story, @PathVariable int storyId) {
		System.out.println("in update story " + story + " " + storyId);
		Story updatedStory = storyService.updateStory(story, storyId);
		List<Subtask> storySubtasks = updatedStory.getStorySubtasks();
		return new ResponseEntity<>(new StoryDTO(story, storySubtasks), HttpStatus.OK);
	}

	@PostMapping("addSubtask/{storyId}")
	public ResponseEntity<?> addSubtaskToStory(@RequestBody Subtask subtask, @PathVariable int storyId) {
		System.out.println("in add subtask " + storyId + " " + subtask);
		Story story = storyService.addSubTask(subtask, storyId);
		List<Subtask> storySubtasks = story.getStorySubtasks();
		return new ResponseEntity<>(new StoryDTO(story, storySubtasks), HttpStatus.OK);
	}

}
