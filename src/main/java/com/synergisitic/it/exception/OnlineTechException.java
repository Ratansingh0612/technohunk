package com.synergisitic.it.exception;

/**
 * @author nagendra.yadav
 * 
 *  This is generic exception , will be thrown when
 *  when any exception will occur inside the application
 */
public class OnlineTechException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OnlineTechException() {
	}
	
	public OnlineTechException(String msg) {
       super(msg);
	}
	
	public OnlineTechException(String msg,Throwable cause) {
	       super(msg,cause);
	}
	
	public OnlineTechException(Throwable cause) {
	       super(cause);
	}
}
