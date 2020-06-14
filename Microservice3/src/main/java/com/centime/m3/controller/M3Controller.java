/**
 * 
 */
package com.centime.m3.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.centime.m3.payload.request.ConcatenatedRequest;

/**
 * Controller for micro service 3
 * 
 * @author rupesh sharma
 *
 */
@RestController
public class M3Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(M3Controller.class);
	
	// SPACE to be concatenated
	private static final String SPACE = " ";
		
	/**
	 * Generate concatenated response of the input request data
	 *  
	 * @param request {@link ConcatenatedRequest} Concatenated request body having Name and Surname to be Concatenated
	 * @return Concatenated response as a string
	 */
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public String getConcatenatedResponse(@Valid @RequestBody ConcatenatedRequest request) {
		
		LOGGER.info("Request received to concatenate with name:{} and surname:{}", request.getName(), request.getSurname());
		
		return new StringBuilder(request.getName()).append(SPACE).append(request.getSurname()).toString();
	}
}
