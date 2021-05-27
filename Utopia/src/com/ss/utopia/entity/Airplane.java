/**
 * 
 */
package com.ss.utopia.entity;

/**
 * @author luisherre
 *
 */
public class Airplane {

	private int id;
	private AirplaneType typeId =  new AirplaneType();

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
	 * @return the typeId
	 */
	public AirplaneType getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(AirplaneType typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Airplane [Id: " + id + ", " + typeId.toString() + "]";
	}
	
	
}
