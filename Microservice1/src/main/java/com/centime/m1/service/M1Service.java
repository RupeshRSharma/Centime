/**
 * 
 */
package com.centime.m1.service;

import com.centime.m1.payload.request.ConcatenatedRequest;

/**
 * Service class for Micro service 1
 * 
 * @author rupesh sharma
 *
 */
public interface M1Service {
	
	/**
	 * Generate concatenated response from M1 and M2 micro service.
	 * 
	 * @param request {@link ConcatenatedRequest} Concatenated request body having Name and Surname to be Concatenated
	 * @return Concatenated response as a string
	 */
	String getConcatenatedResponse(ConcatenatedRequest request);

}
