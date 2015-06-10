package com.interview.evaluationproject.json;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;


public class Company implements Parcelable {

@Expose
private String id;
@Expose
private String projectName;
@Expose
private Double lat;
@Expose
private Double lon;

/**
*
* @return
* The id
*/
public String getId() {
return id;
}

/**
*
* @param id
* The id
*/
public void setId(String id) {
this.id = id;
}

/**
*
* @return
* The projectName
*/
public String getProjectName() {
return projectName;
}

/**
*
* @param projectName
* The projectName
*/
public void setProjectName(String projectName) {
this.projectName = projectName;
}

/**
*
* @return
* The lat
*/
public Double getLat() {
return lat;
}

/**
*
* @param lat
* The lat
*/
public void setLat(Double lat) {
this.lat = lat;
}

/**
*
* @return
* The lon
*/
public Double getLon() {
return lon;
}

/**
*
* @param lon
* The lon
*/
public void setLon(Double lon) {
this.lon = lon;
}

public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
	public Company createFromParcel(Parcel in) {
		return new Company(in);
	}

	public Company[] newArray(int size) {
		return new Company[size];
	}
};

public void copy(Company comp) {
	Parcel p = Parcel.obtain();
	comp.writeToParcel(p, PARCELABLE_WRITE_RETURN_VALUE);
	readFromParcel(p);
}

public Company(Parcel in) {
	readFromParcel(in);
}

public void readFromParcel(Parcel in) {

	this.id = in.readString();
	this.projectName= in.readString();
	this.lat = in.readDouble();
	this.lon = in.readDouble();

}

@Override
public int describeContents() {
	return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {

	dest.writeString(id);
	dest.writeString(projectName);
	dest.writeDouble(lat);
	dest.writeDouble(lon);
	
}

}