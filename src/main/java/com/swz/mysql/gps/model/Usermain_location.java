package com.swz.mysql.gps.model;

public class Usermain_location{
	private int UserMainLocationID;
	private int UserID;
	private int LocationID;
	public void setUserMainLocationID(int UserMainLocationID){
		this.UserMainLocationID = UserMainLocationID;
	}
	public int getUserMainLocationID(){
		return UserMainLocationID;
	}
	public void setUserID(int UserID){
		this.UserID = UserID;
	}
	public int getUserID(){
		return UserID;
	}
	public void setLocationID(int LocationID){
		this.LocationID = LocationID;
	}
	public int getLocationID(){
		return LocationID;
	}
}

