package com.swz.mysql.gps.model;

public class Funcmain{
	private int FuncID;
	private String FuncName;
	private String FuncMemo;
	private int FuncTypeID;
	private byte isdelete;
	private String FuncNum;
	private String code;
	public void setFuncID(int FuncID){
		this.FuncID = FuncID;
	}
	public int getFuncID(){
		return FuncID;
	}
	public void setFuncName(String FuncName){
		this.FuncName = FuncName;
	}
	public String getFuncName(){
		return FuncName;
	}
	public void setFuncMemo(String FuncMemo){
		this.FuncMemo = FuncMemo;
	}
	public String getFuncMemo(){
		return FuncMemo;
	}
	public void setFuncTypeID(int FuncTypeID){
		this.FuncTypeID = FuncTypeID;
	}
	public int getFuncTypeID(){
		return FuncTypeID;
	}
	public void setIsdelete(byte isdelete){
		this.isdelete = isdelete;
	}
	public byte getIsdelete(){
		return isdelete;
	}
	public void setFuncNum(String FuncNum){
		this.FuncNum = FuncNum;
	}
	public String getFuncNum(){
		return FuncNum;
	}
	public void setCode(String code){
		this.code = code;
	}
	public String getCode(){
		return code;
	}
}

