/**
 * 
 */
package com.centime.m4.payload.response;

import java.io.Serializable;

/**
 * Response object for Micro service 4
 * 
 * @author Rupesh Sharma
 *
 */

public class M4DetailsResponse implements Serializable {
	
	/**
	 * Generated Serial version UID
	 */
	private static final long serialVersionUID = 8574631684905898784L;

	private Long id; // id
	
	private Long parentId; // Parent id
	
	private String name; // Name
	
	private String color; // Color

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
}
