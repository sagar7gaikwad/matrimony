package com.hcl.matrimonyapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ApplicationException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ApplicationException(Throwable t, String msg) {
		super(msg, t);
	}

	public ApplicationException(Throwable t) {
		super(t);
	}

	public ApplicationException(String msg) {
		super(msg);
	}

	

}
