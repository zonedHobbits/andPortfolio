package com.example.zonedhobbitsportfolio;

import android.graphics.Bitmap;

public class Person {
	
	String name;
	
	String quote;
	
	String nickName;
	
	String bio;
	
	Bitmap normal_img;
	
	Bitmap fun_img;
	
	String[] contactInfo; //Email, phone, Twitter, URL
	
	Project[] projects;

	public Person(String name, String quote, String nickName, String bio,
			Bitmap normal_img, Bitmap fun_img, String[] contactInfo,
			Project[] projects) {
		super();
		this.name = name;
		this.quote = quote;
		this.nickName = nickName;
		this.bio = bio;
		this.normal_img = normal_img;
		this.fun_img = fun_img;
		this.contactInfo = contactInfo;
		this.projects = projects;
	}

}
