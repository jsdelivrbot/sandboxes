package org.example.repository;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Logged
@Priority(100)
public class RepositoryInterceptor {

	@AroundInvoke
	public Object RepositoryLogger(InvocationContext ctx) throws Exception {
		System.out.println("Repository logger invoked!!!");
		return ctx.proceed();
	}
}
