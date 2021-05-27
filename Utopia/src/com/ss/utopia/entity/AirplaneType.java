/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author luisherre
 *
 */
public class AirplaneType {

	private Integer type;
	private Integer capacity;

	/**
	 * @return the id
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param id the id to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "AirplaneType [Type:" + type + ", Capacity:" + capacity + "]";
	}
	
	

}
