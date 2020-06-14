/**
 * 
 */
package com.centime.m3.payload.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * Model representing reuqest to genearte concatenated response
 * 
 * @author rupesh sharma
 *
 */
@Getter
@Setter
public class ConcatenatedRequest implements Serializable {

	/**
	 * Generated Serial version UID
	 */
	private static final long serialVersionUID = 2111604841759768290L;
	
	@NotBlank(message = "Name can not be blank")
	private String name; // Name, can't be blank
	
	@NotBlank(message = "Surname can not be blank")
	private String surname; // Surname, can't be blank

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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	

}
