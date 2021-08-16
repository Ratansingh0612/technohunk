package com;

import java.io.File;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;

public class GetLocationExample{
	public static void main(String[] args) {
		try {
		File database = new File("C:/Users/Nagendra/git/sssssss/src/main/resources/GeoLite2-City.mmdb");
		DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
		 InetAddress ipAddress = InetAddress.getByName("198.245.51.138");
		CityResponse response = dbReader.city(ipAddress);
	    String countryName = response.getCountry().getName();
	    String cityName = response.getCity().getName();
	    String postal = response.getPostal().getCode();
	    String state = response.getLeastSpecificSubdivision().getName();
	    System.out.println();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}