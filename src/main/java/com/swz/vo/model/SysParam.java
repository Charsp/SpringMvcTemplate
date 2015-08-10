package com.swz.vo.model;

import java.io.Serializable;


public class SysParam  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//参数代码
	private String prCode;

	//父参数代码
	private String parCode;

	//参数值
	private String prValue;

	//参数名称
	private String prName;

	// 参数状态 0-无效 1-有效
	private String prSt;
	
	private String prRemark;
	
	//是否允许业务在页面上修改
	private String prRW;

	public String getPrCode() {
		return prCode;
	}

	public void setPrCode(String prCode) {
		this.prCode = prCode;
	}

	public String getParCode() {
		return parCode;
	}

	public void setParCode(String parCode) {
		this.parCode = parCode;
	}

	public String getPrValue() {
		return prValue;
	}

	public void setPrValue(String prValue) {
		this.prValue = prValue;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getPrSt() {
		return prSt;
	}

	public void setPrSt(String prSt) {
		this.prSt = prSt;
	}

	public String getPrRemark() {
		return prRemark;
	}

	public void setPrRemark(String prRemark) {
		this.prRemark = prRemark;
	}

	public String getPrRW() {
		return prRW;
	}

	public void setPrRW(String prRW) {
		this.prRW = prRW;
	}

	
}
