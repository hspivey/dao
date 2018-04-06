package com.cooksys.dao;

public class Interest {
private Long id;
private String title;

public Interest() {
}

public Interest(Long id, String title) {
	super();
	this.id = id;
	this.title = title;
}

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

@Override
public String toString() {
	return "Interest [id=" + id + ", title=" + title + "]";
}

}
