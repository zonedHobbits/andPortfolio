package com.example.zonedhobbitsportfolio;

import android.graphics.Bitmap;

public class Person {
	
	String name;
	
	String quote;
	
	String nickName;
	
	String bio;
	
	Bitmap normal_img;
	
	Bitmap fun_img;
	
	String email;
	
	String phone;
	
	String twitter;
	
	String url;

	String github;
	
	Project[] projects;

	public Person(String name, String quote, String nickName, String bio,
			Bitmap normal_img, Bitmap fun_img, String email, String phone,
			String twitter, String url, String github, Project[] projects) {
		super();
		this.name = name;
		this.quote = quote;
		this.nickName = nickName;
		this.bio = bio;
		this.normal_img = normal_img;
		this.fun_img = fun_img;
		this.email = email;
		this.phone = phone;
		this.twitter = twitter;
		this.url = url;
		this.github = github;
		this.projects = projects;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Bitmap getNormal_img() {
		return normal_img;
	}

	public void setNormal_img(Bitmap normal_img) {
		this.normal_img = normal_img;
	}

	public Bitmap getFun_img() {
		return fun_img;
	}

	public void setFun_img(Bitmap fun_img) {
		this.fun_img = fun_img;
	}

	public Project[] getProjects() {
		return projects;
	}

	public void setProjects(Project[] projects) {
		this.projects = projects;
	}

}
