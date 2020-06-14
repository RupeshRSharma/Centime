/**
 * 
 */
package com.centime.m1.service.impl;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centime.m1.dao.M2Dao;
import com.centime.m1.dao.M3Dao;
import com.centime.m1.payload.request.ConcatenatedRequest;
import com.centime.m1.service.M1Service;

/**
 * Service implementation of M1Service
 * 
 * @author rupesh sharma
 *
 */
@Service
public class M1ServiceImpl implements M1Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(M1ServiceImpl.class);
	
	@Autowired // Inject Dao for Micro service 2
	private M2Dao m2Dao;

	@Autowired // Inject Dao for Micro service 3
	private M3Dao m3Dao;
	
	// SPACE to be concatenated
	private static final String SPACE = " ";

	@Override
	public String getConcatenatedResponse(ConcatenatedRequest request) {
		
		LOGGER.info("Get Concatenated Response");

		CompletableFuture<String> m2Response = CompletableFuture.supplyAsync(() -> m2Dao.gteM2Response());

		CompletableFuture<String> m3Response = CompletableFuture.supplyAsync(() -> m3Dao.gteM3Response(request));

		LOGGER.info("Response received from both micro services");
		
		return m2Response.thenCombine(m3Response, (m2, m3) -> {
			return new StringBuilder(m2).append(SPACE).append(m3).toString();
		}).join();
	}

}
