package com.synergisitic.it.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synergisitic.it.controller.GuestUserController;

/**
 * 
 * @author nagendra
 *
 */
public class VerifyRecaptcha {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(VerifyRecaptcha.class);
	
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6Lc7wk8UAAAAAIr1Pwzbwp0hpP5bM1t1A2SvejQU";
	private final static String USER_AGENT = "Mozilla/5.0";

	public static boolean verify(String gRecaptchaResponse) throws IOException {
		if(logger.isDebugEnabled()){
			logger.debug("Verifying the captch ..gRecaptchaResponse = "+gRecaptchaResponse);
		}
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
			return false;
		}
		
		try{
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String postParams = "secret=" + secret + "&response="
				+ gRecaptchaResponse;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + postParams);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		if(logger.isDebugEnabled()){
			logger.debug("Verifying the captch response = "+response.toString());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		GoogleCaptchResponse googleCaptchResponse = objectMapper.readValue(response.toString(), GoogleCaptchResponse.class);
		return googleCaptchResponse.isSuccess();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
