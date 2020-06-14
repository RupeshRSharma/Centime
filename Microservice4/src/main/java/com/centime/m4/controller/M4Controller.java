/**
 * 
 */
package com.centime.m4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.centime.m4.service.M4Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller class for Micro service 4
 * 
 * @author rupesh sharma
 *
 */
@Api(value = "Micro servivce 4 Controller")
@RestController
public class M4Controller {
	
	@Autowired // Inject M4 service
	private M4Service m4Service;
	
	/**
	 * Get entity details for the input id
	 * 
	 * @param id Id of the entity
	 * @return Details of the entity with Http status 200 OK
	 */
	@ApiOperation(httpMethod = "GET", value = "Get details")
	@GetMapping("/entities/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> getDetails(@PathVariable("id") Long id) {
		return ResponseEntity.ok(m4Service.getDetails(id));
	}
	
	/**
	 * Get all entities
	 * 
	 * @return List of the entity with Http status 200 OK
	 */
	@ApiOperation(httpMethod = "GET", value = "Get list")
	@GetMapping("/entities")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok(m4Service.getList());
	}
}
