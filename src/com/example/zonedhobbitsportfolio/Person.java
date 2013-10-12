package com.example.zonedhobbitsportfolio;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
	
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
	
	public Person(Parcel p) {
		this.name = p.readString();
		this.quote = p.readString();
		this.nickName = p.readString();
		this.bio = p.readString();
		this.normal_img = p.readParcelable(Bitmap.class.getClassLoader());
		this.fun_img = p.readParcelable(Bitmap.class.getClassLoader());
		this.email = p.readString();
		this.phone = p.readString();
		this.twitter = p.readString();
		this.url = p.readString();
		this.github = p.readString();
		this.projects = (Project[]) p.readArray(Project.class.getClassLoader());
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

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name);
		dest.writeString(quote);
		dest.writeString(nickName);
		dest.writeString(bio);
		normal_img.writeToParcel(dest, PARCELABLE_WRITE_RETURN_VALUE);
		fun_img.writeToParcel(dest, PARCELABLE_WRITE_RETURN_VALUE);
		dest.writeString(email);
		dest.writeString(phone);
		dest.writeString(twitter);
		dest.writeString(url);
		dest.writeString(github);
		dest.writeArray(projects);
		
	}
}
