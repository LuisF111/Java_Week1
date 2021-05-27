/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author luisherre
 *
 */
public class Airport {

	private String airportCode;
	private String city;

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Airport [ " + getAirportCode() + ", " + getCity() + " ]";
	}
	
	
	
}
