package hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect implements ApplicationContextAware {

	private static final Logger log = LoggerFactory.getLogger(TestAspect.class);

	@Autowired
	private ApplicationContext appContext;

	public TestAspect() {
		log.info("TestAspect constructor");
	}

//	@Before("execution(* Test.testMethod1(..))")
	@Before("execution(* hello.TestImpl.testMethod1(..))")
	public void logBeforeV1(JoinPoint joinPoint)
	{
		log.info("TestAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* hello.TestImpl.*(..))")
	//@Before("execution(* Test.*(..))")
	public void logBeforeV2(JoinPoint joinPoint)
	{
		log.info("TestAspect.logBeforeV2() : " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* hello.TestImpl.testMethod1(..))")
	public void logAfterV1(JoinPoint joinPoint)
	{
		log.info("TestAspect.logAfterV1() : " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution(* hello.TestImpl.*(..))")
	public void logAfterV2(JoinPoint joinPoint)
	{
		log.info("TestAspect.logAfterV2() : " + joinPoint.getSignature().getName());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;
	}
}