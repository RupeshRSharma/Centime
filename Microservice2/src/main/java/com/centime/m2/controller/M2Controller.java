/**
 * 
 */
package com.centime.m2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Micro service 2 controller.
 * 
 * @author rupesh sharma
 *
 */

@RestController
public class M2Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(M2Controller.class);
	
	/**
	 * Get Hello response from M2 micro service.
	 * 
	 * @return Response entity string
	 */
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> getResponse() {
		
		LOGGER.info("Request received to get response");
		
		return ResponseEntity.ok("Hello");
	}
}
