package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Subtask {
	@Column(name = "sub_description")
	private String subtaskDescription;

	@Enumerated(EnumType.STRING)
	@Column(name = "sub_status")
	private Status subtaskStatus;

	public Subtask() {
		// TODO Auto-generated constructor stub
	}

	public Subtask(String subtaskDescription, Status subtaskStatus) {
		super();
		this.subtaskDescription = subtaskDescription;
		this.subtaskStatus = subtaskStatus;
	}

	public String getSubtaskDescription() {
		return subtaskDescription;
	}

	public void setSubtaskDescription(String subtaskDescription) {
		this.subtaskDescription = subtaskDescription;
	}

	public Status getSubtaskStatus() {
		return subtaskStatus;
	}

	public void setSubtaskStatus(Status subtaskStatus) {
		this.subtaskStatus = subtaskStatus;
	}

	@Override
	public String toString() {
		return "Subtask [subtaskDescription=" + subtaskDescription + ", subtaskStatus=" + subtaskStatus + "]";
	}

}
