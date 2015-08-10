package com.swz.mysql.gps.model;

public class Location{
	private int LocationID;
	private String LocationName;
	private int LocationParent;
	public void setLocationID(int LocationID){
		this.LocationID = LocationID;
	}
	public int getLocationID(){
		return LocationID;
	}
	public void setLocationName(String LocationName){
		this.LocationName = LocationName;
	}
	public String getLocationName(){
		return LocationName;
	}
	public void setLocationParent(int LocationParent){
		this.LocationParent = LocationParent;
	}
	public int getLocationParent(){
		return LocationParent;
	}
}

