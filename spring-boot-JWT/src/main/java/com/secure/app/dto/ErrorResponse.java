package com.secure.app.dto;

import java.io.Serializable;

/**
 * 
 * @author Jinesh KP
 *
 */

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1812276239332096338L;

	private String errorCode;

	private String errorMessage;

	private String content;

	public ErrorResponse() {

	}

	public ErrorResponse(Exception e) {
		this.errorMessage = e.getMessage();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
