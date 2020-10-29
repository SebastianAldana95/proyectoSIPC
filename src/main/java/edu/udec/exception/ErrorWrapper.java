package edu.udec.exception;

import java.time.LocalDateTime;

public class ErrorWrapper {
	
	private LocalDateTime tiemsatamp;
	private int status;
	private String error;
	private String message;
	private String trace;
	private String path;
	
	public ErrorWrapper() {
	}

	public ErrorWrapper(int status, String error, String message, String trace, String path) {
		super();
		this.tiemsatamp = LocalDateTime.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.trace = trace;
		this.path = path;
	}

	public LocalDateTime getTiemsatamp() {
		return tiemsatamp;
	}

	public void setTiemsatamp(LocalDateTime tiemsatamp) {
		this.tiemsatamp = tiemsatamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
