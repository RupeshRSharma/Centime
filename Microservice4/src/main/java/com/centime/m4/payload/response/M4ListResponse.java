/**
 * 
 */
package com.centime.m4.payload.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response object for Micro service 4
 * 
 * @author Rupesh Sharma
 *
 */
@JsonInclude(Include.NON_NULL)
public class M4ListResponse implements Serializable {

	/**
	 * Generated Serial version UID
	 */
	private static final long serialVersionUID = -2584589044564364027L;
	
	@JsonProperty("Name")
	private String name; // Name
	
	@JsonProperty("Sub Classes")
	private List<M4ListResponse> subClasses; // Children

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
	 * @return the subClasses
	 */
	public List<M4ListResponse> getSubClasses() {
		return subClasses;
	}

	/**
	 * @param subClasses the subClasses to set
	 */
	public void setSubClasses(List<M4ListResponse> subClasses) {
		this.subClasses = subClasses;
	}

}
