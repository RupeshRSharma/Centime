/**
 * 
 */
package com.centime.m1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rupesh sharma
 *
 */
@RestController
public class HealthController {

	/**
	 * Get the Status of the application as a string.
	 * Note: The same can be achieved via Actuator, no need to build custom API, /actuator/health gives the status of the application as UP.
	 * 
	 * @return UP
	 */
	@GetMapping
	public String getServiceStatus() {
		return "UP";
	}
	
}
