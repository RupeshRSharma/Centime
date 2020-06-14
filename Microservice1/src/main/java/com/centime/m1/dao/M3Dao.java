/**
 * 
 */
package com.centime.m1.dao;

import com.centime.m1.payload.request.ConcatenatedRequest;

/**
 * Data access layer to talk to Micro service 3.
 * 
 * @author rupesh sharma
 *
 */
public interface M3Dao {
	
	/**
	 * Get response from Micro service 3.
	 * 
	 * @param ConcatenatedRequest
	 * @return String as the response
	 */
	String gteM3Response(ConcatenatedRequest request);

}
