package com.swz.mysql.gps.model;

public class Equipmenttype{
	private int ID;
	private String EquipmentTypeName;
	private String commands;
	public void setID(int ID){
		this.ID = ID;
	}
	public int getID(){
		return ID;
	}
	public void setEquipmentTypeName(String EquipmentTypeName){
		this.EquipmentTypeName = EquipmentTypeName;
	}
	public String getEquipmentTypeName(){
		return EquipmentTypeName;
	}
	public void setCommands(String commands){
		this.commands = commands;
	}
	public String getCommands(){
		return commands;
	}
}

