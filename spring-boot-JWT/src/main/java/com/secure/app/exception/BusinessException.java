package com.secure.app.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 886489595331745908L;

	private String errorCode;

	public BusinessException() {
		super();
	}

	public BusinessException(String errorMsg) {
		super(errorMsg);
	}

	public BusinessException(String errorMsg, String errorCode) {
		super(errorMsg);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
