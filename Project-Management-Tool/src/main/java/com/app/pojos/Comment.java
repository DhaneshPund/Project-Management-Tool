package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Embeddable
public class Comment {
	@OneToOne
	@JoinColumn(name = "id", nullable = false)
	private User user;
	@Column(name = "comment_text")
	@Lob
	private String commentText;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(User user, String commentText) {
		super();
		this.user = user;
		this.commentText = commentText;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Override
	public String toString() {
		return "Comment [commentText=" + commentText + "]";
	}

}
