/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author luisherre
 *
 */
public class Flight {

	private Integer id;
	private Route route = new Route();
	private Airplane plane = new Airplane();
	private String depatureDateTime;
	private Integer reservedSeats;
	private Float seatPrice;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	/**
	 * @return the depatureDateTime
	 */
	public String getDepatureDateTime() {
		return depatureDateTime;
	}

	/**
	 * @param depatureTime the depatureTime to set
	 */
	public void setDepatureDateTime(String depatureDateTime) {
		this.depatureDateTime = depatureDateTime;
	}

	/**
	 * @return the reservedSeats
	 */
	public Integer getReservedSeats() {
		return reservedSeats;
	}

	/**
	 * @param reservedSeats the reservedSeats to set
	 */
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	/**
	 * @return the seatPrice
	 */
	public Float getSeatPrice() {
		return seatPrice;
	}

	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}

	/**
	 * @return the plane
	 */
	public Airplane getPlane() {
		return plane;
	}

	/**
	 * @param plane the plane to set
	 */
	public void setPlane(Airplane plane) {
		this.plane = plane;
	}

	@Override
	public String toString() {
		return "Flight [Id: " + getId() + ", " + getRoute().toString() + ", DepatureDateTime: " + getDepatureDateTime()
				+ ", ReservedSeats: " + getReservedSeats() + ", SeatPrice: " + getSeatPrice() + ", "
				+ getPlane().toString() + "]";
	}
	
	
	
}
