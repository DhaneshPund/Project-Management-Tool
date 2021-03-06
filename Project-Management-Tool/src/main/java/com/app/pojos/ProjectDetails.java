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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "project_details")
public class ProjectDetails {
	@Id
	@Column(length = 5, name = "unique_pid")
	private String uniquePid;
	
	@Column(length = 15,name = "p_name",unique = true,nullable = false)
	private String projectName;
	@Column(name="p_description")
	private String projectDescription;
	@Column(name="p_start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate projectStartDate;
	@Column(name="p_end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate projectEndDate;
	@ManyToOne
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("userProjects")
	@JsonIgnore
	private User user;
	@OneToMany(mappedBy = "storyProject", cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Story> stories = new ArrayList<>();
	
	public ProjectDetails() {
		System.out.println("in ctor of"+getClass().getName());
	}

	public ProjectDetails(String uniquePid,String projectName, String projectDescription, LocalDate projectStartDate,
			LocalDate projectEndDate) {
		super();
		this.uniquePid =  uniquePid.toUpperCase();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
	}

	public String getUniquePid() {
		return uniquePid.toUpperCase();
	}

	public void setUniquePid(String uniquePid) {
		this.uniquePid = uniquePid.toUpperCase();
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

	public User getUser() {
		return user;
	}

	public void setUsers(User user) {
		this.user = user;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}

	@Override
	public String toString() {
		return "ProjectDetails [uniquePid=" + uniquePid + ", projectName=" + projectName + ", projectDescription="
				+ projectDescription + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate
				+ "]";
	}
	
	//helper methods
	public void addStory(Story s)
	{
		stories.add(s);
	}
	public void removeStory(Story s)
	{
		stories.remove(s);
	}
	
}
