package by.htp.news.dao.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogDAOAspect {
	
	private static final Logger logger = Logger.getLogger(LogDAOAspect.class);
	
	@Before("execution(* by.htp.news.dao.impl.*.*(..))")
	public void log(JoinPoint joinPoint) {
		StringBuilder log = new StringBuilder();
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		log.append(methodSignature.toString());
		log.append(": ");
		
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			log.append(arg + " ");
		}
		
		logger.info(log.toString());
	}
	
}
