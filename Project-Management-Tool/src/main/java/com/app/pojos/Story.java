package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Story {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	@Column(name = "s_name",length = 30)
	private String storyName;
	@Column(name = "s_description")
	private String storyDescription;
	@Enumerated(EnumType.STRING)
	@Column(name = "s_status")
	private Status storyStatus;
	@Enumerated(EnumType.STRING)
	@Column(name = "s_priority")
	private Priority storyPriority;
	@Column(name = "s_points")
	private int storyPoints;
	@Column(name = "s_due_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate storyDueDate;
	@ManyToOne
	@JoinColumn(name = "pid",nullable = false)
	private ProjectDetails storyProject;
	@OneToOne
	@JoinColumn(name = "id")
	private User storyAssignee;
	@ElementCollection
	@CollectionTable(name = "story_subtasks")
	@Column(name="s_subtasks")
	private List<Subtask> storySubtasks = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "story_comments")
	@Column(name = "s_comments")
	private List<Comment> storyComments = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name= "story_files")
	@Column(name = "s_files")
	private List<File> storyFiles = new ArrayList<>();
	
	public Story() {
	System.out.println("in ctor of "+getClass().getName());
	}

	public Story(int sid, String storyName, String storyDescription, Status storyStatus, Priority storyPriority,
			int storyPoints, LocalDate storyDueDate) {
		super();
		this.sid = sid;
		this.storyName = storyName;
		this.storyDescription = storyDescription;
		this.storyStatus = storyStatus;
		this.storyPriority = storyPriority;
		this.storyPoints = storyPoints;
		this.storyDueDate = storyDueDate;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public String getStoryDescription() {
		return storyDescription;
	}

	public void setStoryDescription(String storyDescription) {
		this.storyDescription = storyDescription;
	}

	public Status getStoryStatus() {
		return storyStatus;
	}

	public void setStoryStatus(Status storyStatus) {
		this.storyStatus = storyStatus;
	}

	public Priority getStoryPriority() {
		return storyPriority;
	}

	public void setStoryPriority(Priority storyPriority) {
		this.storyPriority = storyPriority;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public LocalDate getStoryDueDate() {
		return storyDueDate;
	}

	public void setStoryDueDate(LocalDate storyDueDate) {
		this.storyDueDate = storyDueDate;
	}

	public ProjectDetails getStoryProject() {
		return storyProject;
	}

	public void setStoryProject(ProjectDetails storyProject) {
		this.storyProject = storyProject;
	}

	public User getStoryAssignee() {
		return storyAssignee;
	}

	public void setStoryAssignee(User storyAssignee) {
		this.storyAssignee = storyAssignee;
	}

	public List<Subtask> getStorySubtasks() {
		return storySubtasks;
	}

	public void setStorySubtasks(List<Subtask> storySubtasks) {
		this.storySubtasks = storySubtasks;
	}

	public List<Comment> getStoryComments() {
		return storyComments;
	}

	public void setStoryComments(List<Comment> storyComments) {
		this.storyComments = storyComments;
	}

	public List<File> getStoryFiles() {
		return storyFiles;
	}

	public void setStoryFiles(List<File> storyFiles) {
		this.storyFiles = storyFiles;
	}

	@Override
	public String toString() {
		return "Story [sid=" + sid + ", storyName=" + storyName + ", storyDescription=" + storyDescription
				+ ", storyStatus=" + storyStatus + ", storyPriority=" + storyPriority + ", storyPoints=" + storyPoints
				+ ", storyDueDate=" + storyDueDate + "]";
	}
	
	//helper methods
		public void addSubtask(Subtask sub)
		{
			storySubtasks.add(sub);
		}
		public void removeUser(Subtask sub)
		{
			storySubtasks.remove(sub);
		}
		public void addStory(Comment c)
		{
			storyComments.add(c);
		}
		public void removeStory(Comment c)
		{
			storyComments.remove(c);
		}
		
		public void addFile(File f)
		{
			storyFiles.add(f);
		}
		public void removeFile(File f)
		{
			storyFiles.remove(f);
		}
		
}
