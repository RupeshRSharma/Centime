/**
 * 
 */
package com.centime.m1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.centime.m1.dao.M3Dao;
import com.centime.m1.payload.request.ConcatenatedRequest;

/**
 * DAO implementation for M3Dao.
 * 
 * @author rupesh sharma
 *
 */
@Service
public class M3DaoImpl implements M3Dao {

	@Autowired // Inject Rest template to call Micro service 3
	private RestTemplate restTemplate;
	
	@Value("${m3.url}")
	private String m3Url; // Micro service 3 URL
	
	@Override
	public String gteM3Response(ConcatenatedRequest request) {
		return restTemplate.postForObject(m3Url, request, String.class);
	}

}
