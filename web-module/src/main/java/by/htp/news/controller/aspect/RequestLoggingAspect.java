package by.htp.news.controller.aspect;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RequestLoggingAspect {
	
	private static final Logger logger = Logger.getLogger(RequestLoggingAspect.class);
	
	@Pointcut("execution(* by.htp.news.controller.*.*(..))")
	private void forControllerPackage() { }
	
	@Pointcut("forControllerPackage() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
	private void forGetRequest() {}
	
	@Pointcut("forControllerPackage() && @annotation(org.springframework.web.bind.annotation.PostMapping)")
	private void forPostRequest() {}

	@Pointcut("forGetRequest() || forPostRequest()")
	private void forAllRequest() {}
	
	@Before("forAllRequest()")
	public void requestLogging() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String url = request.getRequestURL().toString();
		String address = request.getRemoteAddr();
		String method = request.getMethod();
		logger.info("request: " + method + " '" + url + "', ip: " + address);
	}				
}
