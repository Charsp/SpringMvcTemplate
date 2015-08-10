package com.swz.mysql.gps.model;

public class Command{
	private int CommandID;
	private String CommandName;
	private String CommandCode;
	private String CommandParam;
	public void setCommandID(int CommandID){
		this.CommandID = CommandID;
	}
	public int getCommandID(){
		return CommandID;
	}
	public void setCommandName(String CommandName){
		this.CommandName = CommandName;
	}
	public String getCommandName(){
		return CommandName;
	}
	public void setCommandCode(String CommandCode){
		this.CommandCode = CommandCode;
	}
	public String getCommandCode(){
		return CommandCode;
	}
	public void setCommandParam(String CommandParam){
		this.CommandParam = CommandParam;
	}
	public String getCommandParam(){
		return CommandParam;
	}
}

