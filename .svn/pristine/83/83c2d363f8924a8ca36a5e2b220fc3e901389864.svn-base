package com.swz.mysql.gps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log4j")
public class Log4j {
	@Id
	private int id;
	private Date op_date;
	@Column(name = "op_message", columnDefinition = "TEXT")
	private String op_message;
	private String op_type;
	private String operator;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setOp_date(Date op_date) {
		this.op_date = op_date;
	}

	public Date getOp_date() {
		return op_date;
	}

	public void setOp_message(String op_message) {
		this.op_message = op_message;
	}

	public String getOp_message() {
		return op_message;
	}

	public void setOp_type(String op_type) {
		this.op_type = op_type;
	}

	public String getOp_type() {
		return op_type;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}
}
