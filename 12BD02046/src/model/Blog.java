package model;

import java.util.Date;


public class Blog {
	public String newBlog;
	public Date date;
	
	public Blog(){}
	public Blog(String newBlog) {
		this.newBlog = newBlog;
	}

	
	public String getNewBlog() {
		return newBlog;
	}
	public void setNewBlog(String newBlog) {
		this.newBlog = newBlog;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		return  date + "\n" + newBlog +" \n";
			   
	}
	
	
	
	
}

