package com.project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("Aspect")
@Aspect
public class AspectClass {
	
	@Around("execution(* login(..))")
	public void logLogin(ProceedingJoinPoint pjp) throws Throwable { 
		System.out.println("-------Logging Aspect login() method: " + pjp.getSignature().getName() + ": Before Method Execution");
		pjp.proceed();
		System.out.println("-------Logging Aspect login() method: " + pjp.getSignature().getName() + ": After Method Execution");
	}
	
	@Around("execution(* register(..))")
	public void logRegister(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------Logging Aspect register() method: " + pjp.getSignature().getName() + ": Before Method Execution");
		pjp.proceed();
		System.out.println("-------Logging Aspect register() method: " + pjp.getSignature().getName() + ": After Method Execution");
	}
	
	@Around("execution(* creationOfSupportGroup(..))")
	public void logCreateSupportGroup(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------Logging Aspect creationOfSupportGroup() method: " + pjp.getSignature().getName() + ": Before Method Execution");
		pjp.proceed();
		System.out.println("-------Logging Aspect creationOfSupportGroup() method: " + pjp.getSignature().getName() + ": After Method Execution");
		System.out.println("Successful addition of a support group");
	}
	
	@After("execution(* getAllSupportGroups(..))")
	public void logGetAllSupportGroups(JoinPoint jp) {
		System.out.println("--------Logging Aspect getAllSupportGroups() method: " + jp.getSignature().getName() + ": After Method Execution");
		System.out.println("Retrieve all the support groups stored in the database.");
	}
	
	@After("execution(* getAllUserSupportGroups(..))")
	public void logGetAllUserSupportGroups(JoinPoint jp) {
		System.out.println("--------Logging Aspect getAllUserSupportGroups() method: " + jp.getSignature().getName() + ": After Method Execution");
		System.out.println("Retrieve all the user support groups stored in the database.");
	}
	
	@Around("execution(* joinSupportGroup(..))")
	public void logJoinSupportGroup(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------Logging Aspect joinSupportGroup() method: " + pjp.getSignature().getName() + ": Before Method Execution");
		pjp.proceed();
		System.out.println("-------Logging Aspect joinSupportGroup() method: " + pjp.getSignature().getName() + ": After Method Execution");
		System.out.println("The user sucessfully joined the group.");
	}
	
	@Around("exeuction(* leaveSupportGroup(..))")
	public void logLeaveSupportGroup(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------Logging Aspect leaveSupportGroup() method: " + pjp.getSignature().getName() + ": Before Method Execution");
		pjp.proceed();
		System.out.println("-------Logging Aspect leaveSupportGroup() method: " + pjp.getSignature().getName() + ": After Method Execution");
		System.out.println("The user sucessfully joined the group.");
	}
	
	@Around("execution(* creationOfPost(..))")
	public void logCreationOfPost(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------Logging Aspect creationOfPost() method: " + pjp.getSignature().getName() + ": Before Method Execution");
		pjp.proceed();
		System.out.println("-------Logging Aspect creationOfPost() method: " + pjp.getSignature().getName() + ": After Method Execution");
		System.out.println("Successful addition of a post");
	}
	
	@After("execution(* getSpecficPost(..))")
	public void logGetSpecficPost(JoinPoint jp) {
		System.out.println("--------Logging Aspect getSpecficPost() method: " + jp.getSignature().getName() + ": After Method Execution");
		System.out.println("Retrieve all the support group's post stored in the database.");
	}
	
	@After("execution(* getAllPost(..))")
	public void logGetAllPost(JoinPoint jp) {
		System.out.println("--------Logging Aspect getAllPost() method: " + jp.getSignature().getName() + ": After Method Execution");
		System.out.println("Retrieve all the post stored in the database.");
	}
	
	@Around("execution(* creationOfReplies(..))")
	public void logCreationOfReplies(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-------Logging Aspect creationOfReplies() method: " + pjp.getSignature().getName() + ": Before Method Execution");
		pjp.proceed();
		System.out.println("-------Logging Aspect creationOfReplies() method: " + pjp.getSignature().getName() + ": After Method Execution");
		System.out.println("Successful addition of a reply");
	}
	
	@After("execution(* getAllRepliesByPostId(..))")
	public void logGetAllRepliesByPostId(JoinPoint jp) {
		System.out.println("--------Logging Aspect getAllRepliesByPostId() method: " + jp.getSignature().getName() + ": After Method Execution");
		System.out.println("Retrieve all the replies based on a post stored in the database.");
	}

}
