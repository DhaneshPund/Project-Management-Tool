package com.app.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.StoryDTO;
import com.app.pojos.File;
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
		System.out.println("list of stories "+storyList);
		for (Story story : storyList) {
			List<Subtask> storySubtasks = storyService.getStorySubtasks(story);
			List<File> storyFiles = story.getStoryFiles();
			listStoryDTO.add(new StoryDTO(story, storySubtasks,storyFiles));
		}
		return new ResponseEntity<>(listStoryDTO, HttpStatus.OK);
	}
	@GetMapping("getStory/{sid}")
	public ResponseEntity<?> getStoryDetails(@PathVariable int sid){
		System.out.println("in get story details" + sid);
		return new ResponseEntity<>(new StoryDTO(storyService.getStoryDetails(sid)), HttpStatus.OK);
	}
	
	@PostMapping("add/{uniquePid}")
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
		System.out.println("updated story "+updatedStory);
		List<Subtask> storySubtasks = storyService.getStorySubtasks(updatedStory);
		List<File> storyFiles = updatedStory.getStoryFiles();
		return new ResponseEntity<>(new StoryDTO(story, storySubtasks,storyFiles), HttpStatus.OK);
	}

	@PostMapping("addSubtask/{storyId}")
	public ResponseEntity<?> addSubtaskToStory(@RequestBody Subtask subtask, @PathVariable int storyId) {
		System.out.println("in add subtask " + storyId + " " + subtask);
		Story story = storyService.addSubTask(subtask, storyId);
		System.out.println("story "+story);
		List<Subtask> storySubtasks = storyService.getStorySubtasks(story);
		List<File> storyFiles = story.getStoryFiles();
		return new ResponseEntity<>(new StoryDTO(story, storySubtasks,storyFiles), HttpStatus.OK);
	}

	@PostMapping("/upload/{storyId}")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable int storyId) throws IOException {		
			Story story = storyService.store(file,storyId);
			List<Subtask> storySubtasks = storyService.getStorySubtasks(story);
			List<File> storyFiles = story.getStoryFiles();
			return new ResponseEntity<>(new StoryDTO(story, storySubtasks,storyFiles), HttpStatus.OK);
	}
}
