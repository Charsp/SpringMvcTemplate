package com.swz.mysql.gps.model;

public class Alarm{
	private long AlarmID;
	private String AlarmCode;
	private String AlarmMemo;
	public void setAlarmID(long AlarmID){
		this.AlarmID = AlarmID;
	}
	public long getAlarmID(){
		return AlarmID;
	}
	public void setAlarmCode(String AlarmCode){
		this.AlarmCode = AlarmCode;
	}
	public String getAlarmCode(){
		return AlarmCode;
	}
	public void setAlarmMemo(String AlarmMemo){
		this.AlarmMemo = AlarmMemo;
	}
	public String getAlarmMemo(){
		return AlarmMemo;
	}
}

