package com.techquiz.codings.web.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author VC1
 * @Since 27-JUL-2018
 *  
 */
@JsonInclude(value=Include.NON_NULL)
public class JavaCodeResponse {
	private String status;
	private String compilationError;
	private String input;
	private String output;
	private String junitResult;
	private int testPass;
	private int testFail;
	private String description;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompilationError() {
		return compilationError;
	}

	public void setCompilationError(String compilationError) {
		this.compilationError = compilationError;
	}

	public String getJunitResult() {
		return junitResult;
	}

	public void setJunitResult(String junitResult) {
		this.junitResult = junitResult;
	}

	public int getTestPass() {
		return testPass;
	}

	public void setTestPass(int testPass) {
		this.testPass = testPass;
	}

	public int getTestFail() {
		return testFail;
	}

	public void setTestFail(int testFail) {
		this.testFail = testFail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "JavaCodeResponse [status=" + status + ", compilationError=" + compilationError + ", input=" + input
				+ ", output=" + output + ", junitResult=" + junitResult + ", testPass=" + testPass + ", testFail="
				+ testFail + ", description=" + description + "]";
	}


}
