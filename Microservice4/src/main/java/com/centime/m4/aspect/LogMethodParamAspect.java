/**
 * 
 */
package com.centime.m4.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.centime.m4.annotation.LogMethodParam;

/**
 * Aspect to log method parameters.
 * 
 * @author Rupesh Sharma
 *
 */
@Component
@Aspect
public class LogMethodParamAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogMethodParamAspect.class);
	
	/**
	 * Log method parameters
	 * 
	 * @param joinPoint
	 * @param logMethodParam
	 */
	@Before("execution(* *.*(..)) && @annotation(logMethodParam)")
	public void logMethodParams(JoinPoint joinPoint, LogMethodParam logMethodParam) {	
		LOGGER.info("Logging method parameters for method {}", joinPoint.getSignature().getName());
		Arrays.stream(joinPoint.getArgs()).forEach(arg -> LOGGER.info(arg.toString()));
	}
}
