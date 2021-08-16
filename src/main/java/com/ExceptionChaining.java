package com;

import java.sql.Timestamp;

//jkjhghd
class SynerException extends Exception {
	public SynerException(String message) {
		super(message);
	}

	public SynerException(String message, Throwable cause) {
		super(message, cause);
	}
}

public class ExceptionChaining {

	public void showA() throws SynerException {
		try {
			showB();
		}catch(SynerException exception){
			throw exception;
		}catch (Exception e) {
			SynerException exception=new SynerException("Exception occur inside the method A");
			exception.initCause(e);
			throw exception;
		}

	}

	public void showB() throws SynerException{
		try {
			showC();
		}catch(SynerException exception){
			throw exception;
		}catch (Exception e) {
			SynerException exception=new SynerException("Exception occur inside the method B");
			exception.initCause(e);
			throw exception;
		}
	}

	public void showC() throws SynerException{
		try{
			
		}catch(Exception e){
			SynerException exception=new SynerException("Exception occur inside the method c");
			exception.initCause(e);
			throw exception;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			try{
				ExceptionChaining chaining=new ExceptionChaining();
				chaining.showA();
			}catch(SynerException exception){
				System.out.println(exception.getMessage());
				//printing actual cause
				System.out.println(exception.getCause());
			}
	}

}
