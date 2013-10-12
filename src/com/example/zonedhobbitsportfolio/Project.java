package com.example.zonedhobbitsportfolio;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Project implements Parcelable {
	
	String name;
	
	String tagline;
	
	Person creator;
	
	String desc;
	
	String type;
	
	Bitmap thumbnail;
	
	Bitmap[] shots; //Screenshots, images

	public Project(String name, String tagline, Person creator, String desc,
			String type, Bitmap thumbnail, Bitmap[] shots) {
		super();
		this.name = name;
		this.tagline = tagline;
		this.creator = creator;
		this.desc = desc;
		this.type = type;
		this.thumbnail = thumbnail;
		this.shots = shots;
	}

	public Project(Parcel p) {
		this.name = p.readString();
		this.tagline = p.readString();
		this.creator = p.readParcelable(Person.class.getClassLoader());
		this.desc = p.readString();
		this.type = p.readString();
		this.thumbnail = p.readParcelable(Bitmap.class.getClassLoader());
		this.shots = (Bitmap[]) p.readArray(Bitmap.class.getClassLoader());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Bitmap getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Bitmap thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Bitmap[] getShots() {
		return shots;
	}

	public void setShots(Bitmap[] shots) {
		this.shots = shots;
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
		dest.writeString(tagline);
		dest.writeParcelable(creator, PARCELABLE_WRITE_RETURN_VALUE);
		dest.writeString(desc);
		dest.writeString(type);
		thumbnail.writeToParcel(dest, PARCELABLE_WRITE_RETURN_VALUE);
		dest.writeArray(shots);
		
	}

	
	
}
