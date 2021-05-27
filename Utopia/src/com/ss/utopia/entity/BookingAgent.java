package com.ss.utopia.entity;

public class BookingAgent {
	
	private Booking booking = new Booking();
	private User agentId;

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @return the id
	 */
	public User getAgentId() {
		return agentId;
	}

	/**
	 * @param id the id to set
	 */
	public void setAgentId(User user) {
		this.agentId = user;
	}

}
