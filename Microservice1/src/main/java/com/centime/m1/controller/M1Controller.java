/**
 * 
 */
package com.centime.m1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.centime.m1.payload.request.ConcatenatedRequest;
import com.centime.m1.service.M1Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * @author rupesh sharma
 *
 */
@Api(value = "Micro servivce 1 Controller")
@RestController
public class M1Controller {
	
	@Autowired // Inject M1 service
	private M1Service m1Service;
	
	/**
	 * Generate concatenated response from M1 and M2 micro service.
	 * 
	 * @param request {@link ConcatenatedRequest} Concatenated request body having Name and Surname to be Concatenated
	 * @return Concatenated response as a string
	 */
	@ApiOperation(httpMethod = "POST", value = "Get Concatenated Response")
	@ApiResponse(code = 400, message = "Request is invalid.")
	@PostMapping
	public String getConcatenatedResponse(@Valid @RequestBody ConcatenatedRequest request) {
		return m1Service.getConcatenatedResponse(request);
	}
}
