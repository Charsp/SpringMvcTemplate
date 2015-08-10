package com.swz.mysql.gps.model;

public class Equipment{
	private int id;
	private String equipmentNum;
	private byte isMainEquipment;
	private byte isdelete;
	private String simNum;
	private int terminalType;
	private String userDefinition;
	private String vehPhone;
	private int vehId;
	private String linkedType;
	private String commands;
	private String password;
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setEquipmentNum(String equipmentNum){
		this.equipmentNum = equipmentNum;
	}
	public String getEquipmentNum(){
		return equipmentNum;
	}
	public void setIsMainEquipment(byte isMainEquipment){
		this.isMainEquipment = isMainEquipment;
	}
	public byte getIsMainEquipment(){
		return isMainEquipment;
	}
	public void setIsdelete(byte isdelete){
		this.isdelete = isdelete;
	}
	public byte getIsdelete(){
		return isdelete;
	}
	public void setSimNum(String simNum){
		this.simNum = simNum;
	}
	public String getSimNum(){
		return simNum;
	}
	public void setTerminalType(int terminalType){
		this.terminalType = terminalType;
	}
	public int getTerminalType(){
		return terminalType;
	}
	public void setUserDefinition(String userDefinition){
		this.userDefinition = userDefinition;
	}
	public String getUserDefinition(){
		return userDefinition;
	}
	public void setVehPhone(String vehPhone){
		this.vehPhone = vehPhone;
	}
	public String getVehPhone(){
		return vehPhone;
	}
	public void setVehId(int vehId){
		this.vehId = vehId;
	}
	public int getVehId(){
		return vehId;
	}
	public void setLinkedType(String linkedType){
		this.linkedType = linkedType;
	}
	public String getLinkedType(){
		return linkedType;
	}
	public void setCommands(String commands){
		this.commands = commands;
	}
	public String getCommands(){
		return commands;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
}

