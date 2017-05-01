package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.utility.RestResponse;  

@Component
@Aspect  
public class TrackOperation{  
    @Pointcut("execution(* com.controllers.*.*(..))")  
    public void k(){}//pointcut name  
      
    /*This advice call on two param's method of Operation class */
    //@Before("k()")//applying pointcut on before advice  
    /*@Before("execution(* com.controllers.*.*(..)) && args(batch,batch2)")
    public void myadvice(JoinPoint jp, String batch, String batch2)//it is advice (before advice)  
    {  
        System.out.println("additional double args concern"+batch+"--"+batch2);
    }*/
   
    /*This advice call on one param's method of Operation class */
    @Before("execution(* com.controllers.*.*(..)) && args(batch,..)")
    public void myadvice(JoinPoint jp, String batch)//it is advice (before advice)  
    {  
        System.out.println("additional single args concern"+batch);
        batch = batch+" change";
    }
    
    /*This advice call on without param's method of Operation class */
    @Before("execution(* com.controllers.*.*())")
    public void myadvice(JoinPoint jp)//it is advice (before advice)  
    {  
        System.out.println("additional concern");  
    }
    
    /*This advice call on all Operation class methods */
    @Before("execution(* com.controllers.*.*(..))")
    public void myadviceAll(JoinPoint jp)//it is advice (before advice)  
    {  
        System.out.println("additional concern. "+jp.getSignature().getName());  
    }
    
    @Around("execution(* com.controllers.UserController.getAllUsers(..))")
    public RestResponse unifyResponse(ProceedingJoinPoint pjp) throws Throwable {
        
        Object controllerResult = pjp.proceed();
        RestResponse result;
        
        if(controllerResult!=null)
        	result = new RestResponse(200, controllerResult);
        else 
        	result = new RestResponse(0, "Null");
        
        return result;
    }
    
   /* @AfterThrowing(pointcut="execution(* com.controllers.*.*(..))",
    	    throwing="excep")
    public void afterThrowing(JoinPoint joinPoint, Throwable excep) throws Throwable {
        System.out.println("Inside CatchThrowException.afterThrowing() method...");
        System.out.println("Running after throwing exception...");
        System.out.println("Exception : " + excep);
    }*/
}  