package blogz;

import java.util.Date;

public class Post extends Entity{
	
	private String body, title, author;
	private final Date created;
	private Date lastModified;
	
	public Post(String title, String body, String author){
		super();
		this.title = title;
		this.body = body;
		this.author = author;
		this.created = new Date();
		this.lastModified = new Date();
	}
	
	private void modified(){
		this.lastModified = new Date();
	}
	
	public void updateBody(String newBody){
		this.body = newBody;
		modified();
	}
	
	public void updateTitle(String newTitle){
		this.title = newTitle;
		modified();
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getBody(){
		return this.body;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public Date getCreated(){
		return this.created;
	}
	
	public Date getLastModified(){
		return this.lastModified;
	}
	
	
}