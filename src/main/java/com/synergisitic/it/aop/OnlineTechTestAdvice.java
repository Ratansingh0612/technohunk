package com.synergisitic.it.aop;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OnlineTechTestAdvice {
	

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory
			.getLog(OnlineTechTestAdvice.class);

	@Before("execution(*  com.synergisitic.it.dao.impl.*.*(..))")
	public void addStatementBeforeDao(JoinPoint joinPoint) {
		if (logger.isDebugEnabled()) {
			logger.debug("Method Name : " + joinPoint.getSignature().getName());
			logger.debug("Method parameters : "
					+ Arrays.asList(joinPoint.getArgs()));
		}
	}

	@Before("execution(*  com.synergisitic.it.service.impl.*.*(..))")
	public void addStatementBeforeService(JoinPoint joinPoint) {
		if (logger.isDebugEnabled()) {
			logger.debug("Method Name : " + joinPoint.getSignature().getName());
			logger.debug("Method parameters : "
					+ Arrays.asList(joinPoint.getArgs()));
		}
	}

}
