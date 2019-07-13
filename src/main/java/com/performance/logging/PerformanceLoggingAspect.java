/**
 * 
 */
package com.performance.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author Sumanth
 *
 */

@Component
@Aspect
public class PerformanceLoggingAspect {
	
	private static final Logger LOG = LoggerFactory.getLogger(PerformanceLoggingAspect.class);
	
	@Around("execution(* com.performance.logging..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint joinPoint) throws Throwable
	{
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String className = signature.getDeclaringType().getName();
		String methodName = signature.getName();
		
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = joinPoint.proceed();
		stopWatch.stop();
		
		LOG.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");
		return result;
	}
	

}
