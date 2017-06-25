package com.ssga.hjl.entity;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum PathType {
		LOCAL, REMOTE;
		public String getName() {
			return this.name();
		}
	}
	
	private Long id;
	private String title;
	private String path;
	private Date publicationDate;
	private PathType pathType = PathType.LOCAL;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public PathType getPathType() {
		return pathType;
	}
	public void setPathType(PathType pathType) {
		this.pathType = pathType;
	}
}
