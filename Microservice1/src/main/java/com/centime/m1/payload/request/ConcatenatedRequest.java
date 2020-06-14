/**
 * 
 */
package com.centime.m1.payload.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Model representing reuqest to genearte concatenated response.")
public class ConcatenatedRequest implements Serializable {

	/**
	 * Generated Serial version UID
	 */
	private static final long serialVersionUID = 2111604841759768290L;
	
	@NotBlank(message = "Name can not be blank")
	@ApiModelProperty(notes = "Name", required = true)
	private String name; // Name, can't be blank
	
	@NotBlank(message = "Surname can not be blank")
	@ApiModelProperty(notes = "Surname", required = true)
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
