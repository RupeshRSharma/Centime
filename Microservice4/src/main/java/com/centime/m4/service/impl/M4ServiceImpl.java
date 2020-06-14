/**
 * 
 */
package com.centime.m4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.centime.m4.annotation.LogMethodParam;
import com.centime.m4.entity.M4Entity;
import com.centime.m4.payload.response.M4DetailsResponse;
import com.centime.m4.payload.response.M4ListResponse;
import com.centime.m4.respository.M4Respository;
import com.centime.m4.service.M4Service;

/**
 * Service implementation for M4Service
 * 
 * @author Rupesh Sharma
 *
 */
@Service
public class M4ServiceImpl implements M4Service {

	@Autowired // Inject M4Respository
	private M4Respository repository;

	@Override
	@LogMethodParam
	public M4DetailsResponse getDetails(Long id) {

		// Get the entity form database, otherwise return null
		M4Entity entity = repository.findById(id).orElse(null);

		// Create the response
		M4DetailsResponse response = new M4DetailsResponse();

		// If entity if present, populate the data
		if (null != entity) {

			response.setId(entity.getId());
			response.setParentId(entity.getParentId());
			response.setName(entity.getName());
			response.setColor(entity.getColor());
		}

		// return the response
		return response;

	}

	@Override
	public List<M4ListResponse> getList() {

		// Get all the entities from database
		List<M4Entity> entityList = repository.findAll();

		// Create response list
		List<M4ListResponse> responseList = new ArrayList<>();

		// Iterate over the parent entities i.e. parentId == 0 and add their children
		entityList.stream().filter(Objects::nonNull).filter(entity -> entity.getParentId() == 0).forEach(entity -> {

			M4ListResponse response = new M4ListResponse();
			response.setName(entity.getName());
			response.setSubClasses(addChildren(entity));

			responseList.add(response);
		});

		return responseList;
	}

	/**
	 * Add children of the entities to response recursively
	 * 
	 * @param entity Entity
	 * @return Response list
	 */
	private List<M4ListResponse> addChildren(M4Entity entity) {
		
		// If there are no children of the entity, return
		if (CollectionUtils.isEmpty(entity.getChildren())) {
			return null;
		}

		// Create the children list
		List<M4ListResponse> responseList = new ArrayList<>();

		// Iterate over each child and add it to the children list
		entity.getChildren().forEach(child -> {
			M4ListResponse response = new M4ListResponse();
			response.setName(child.getName());
			response.setSubClasses(addChildren(child));
			responseList.add(response);
		});
		
		return responseList;

	}

}
