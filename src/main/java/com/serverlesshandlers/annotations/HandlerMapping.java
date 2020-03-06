package com.serverlesshandlers.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
 *  Annotation to create request handlers for lambda functions
 */



@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandlerMapping {
	
	public String path() default "";
	public HttpType httpMethod() default HttpType.GET;


}
