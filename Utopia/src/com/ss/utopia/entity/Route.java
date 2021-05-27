/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author luisherre
 *
 */
public class Route {

	private int id;
	private Airport origin = new Airport();
	private Airport destination = new Airport();

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the origin
	 */
	public Airport getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public Airport getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Route [Id: " + getId() + ", Origin: " + getOrigin().toString() + ", Dest: "
				+ getDestination().toString() + "]";
	}

}
