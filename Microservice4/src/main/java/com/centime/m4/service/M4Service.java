/**
 * 
 */
package com.centime.m4.service;

import java.util.List;

import com.centime.m4.payload.response.M4DetailsResponse;
import com.centime.m4.payload.response.M4ListResponse;

/**
 * Service class for Micro service 4 
 * 
 * @author Rupesh Sharma
 *
 */
public interface M4Service {
	
	/**
	 * Get details of the entity based on the id.
	 * 
	 * @param id Id of the entity
	 * @return Details of the entity
	 */
	public M4DetailsResponse getDetails(Long id);
	
	/**
	 * Get list of entities.
	 * 
	 * @return List of entities
	 */
	public List<M4ListResponse> getList();
	 

}
