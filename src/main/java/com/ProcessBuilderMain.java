package com;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class ProcessBuilderMain {
	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("pwd");
		String output = IOUtils.toString(pb.start().getInputStream());
		String error = IOUtils.toString(pb.start().getErrorStream());
		if(output.length()>0)
		System.out.println("output = "+output);
		if(error.length()>0)
		System.out.println("error = "+error);
	}
}
