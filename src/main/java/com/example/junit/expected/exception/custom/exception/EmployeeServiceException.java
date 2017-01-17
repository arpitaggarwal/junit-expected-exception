package com.example.junit.expected.exception.custom.exception;

public class EmployeeServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(String message) {
		super(message);
	}

	public EmployeeServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeServiceException(Throwable cause) {
		super(cause);
	}

	protected EmployeeServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
