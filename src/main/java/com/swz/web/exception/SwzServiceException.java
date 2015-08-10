package com.swz.web.exception;

//import org.springframework.dao.DataAccessException;
// 
//
//public class SwzServiceException extends DataAccessException {
public class SwzServiceException {

	public SwzServiceException(String msg) {
		// super(msg);
	}

	public SwzServiceException(String msg, Throwable cause) {
		// super(msg, cause);
	}

	public SwzServiceException(Throwable cause) {
		// super("SWZ Service layout exception : ", cause);
	}

}
