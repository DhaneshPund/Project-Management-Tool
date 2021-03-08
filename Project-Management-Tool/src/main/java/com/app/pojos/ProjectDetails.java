package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "project_details")
public class ProjectDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column(length = 15,name = "p_name")
	private String projectName;
	@Column(name="p_description")
	private String projectDescription;
	@Column(name="p_start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate projectStartDate;
	@Column(name="p_end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate projectEndDate;
	@OneToMany(mappedBy = "userProject",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties("userProject")
	@JsonIgnore
	private List<User> users=new ArrayList<>();
	@OneToMany(mappedBy = "storyProject", cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Story> stories = new ArrayList<>();
	
	public ProjectDetails() {
		System.out.println("in ctor of"+getClass().getName());
	}

	public ProjectDetails(int pid, String projectName, String projectDescription, LocalDate projectStartDate,
			LocalDate projectEndDate) {
		super();
		this.pid = pid;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public LocalDate getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(LocalDate projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	@Override
	public String toString() {
		return "ProjectDetails [pid=" + pid + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate
				+ "]";
	}
	
	//helper methods
	public void addUser(User u)
	{
		users.add(u);
		u.setUserProject(this);
	}
	public void removeUser(User u)
	{
		users.remove(u);
		u.setUserProject(null);
	}
	public void addStory(Story s)
	{
		stories.add(s);
	}
	public void removeStory(Story s)
	{
		stories.remove(s);
	}
	
}
