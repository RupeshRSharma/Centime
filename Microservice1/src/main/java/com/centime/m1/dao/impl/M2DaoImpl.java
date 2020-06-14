/**
 * 
 */
package com.centime.m1.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.centime.m1.dao.M2Dao;

/**
 * DAO implementation for M2Dao.
 * 
 * @author rupesh sharma
 *
 */
@Service
public class M2DaoImpl implements M2Dao {

	@Autowired // Inject Rest template to call Micro service 2
	private RestTemplate restTemplate;
	
	@Value("${m2.url}")
	private String m2Url; // Micro service 2 URL
	
	@Override
	public String gteM2Response() {
		return restTemplate.getForObject(m2Url, String.class);
	}

}
