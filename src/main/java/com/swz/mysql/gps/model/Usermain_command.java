package com.swz.mysql.gps.model;

public class Usermain_command{
	private int ID;
	private int UserID;
	private int CommandID;
	public void setID(int ID){
		this.ID = ID;
	}
	public int getID(){
		return ID;
	}
	public void setUserID(int UserID){
		this.UserID = UserID;
	}
	public int getUserID(){
		return UserID;
	}
	public void setCommandID(int CommandID){
		this.CommandID = CommandID;
	}
	public int getCommandID(){
		return CommandID;
	}
}

