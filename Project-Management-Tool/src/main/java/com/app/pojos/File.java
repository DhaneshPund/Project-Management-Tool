package com.app.pojos;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class File {
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file_type")
	private String fileType;
	
	@Column(name = "file_data")
	@Lob
	private byte[] fileData;
	
	
	public File() {
		// TODO Auto-generated constructor stub
	}
	
	public File(String fileName, String fileType, byte[] fileData) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	@Override
	public String toString() {
		return "File [fileName=" + fileName + ", fileType=" + fileType + ", fileData=" + Arrays.toString(fileData)
				+ "]";
	}
}
