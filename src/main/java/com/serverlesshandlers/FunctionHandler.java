package com.serverlesshandlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.serverlesshandlers.annotations.RestHandlerMapping;
import com.serverlesshandlers.annotations.HttpType;

public abstract class FunctionHandler implements RequestHandler<Map<String, Object>, Response> {

	private static final Logger LOG = Logger.getLogger(FunctionHandler.class);
	
	private Map<String,Map<HttpType,RestHandlers>> handlerMap = new HashMap<>();


	public FunctionHandler() {
		super();
		System.out.println("Init");
		final Reflections reflections = new Reflections();
		final Set<Class<?>> handlerClasses = reflections.getTypesAnnotatedWith(RestHandlerMapping.class,true);
		
		
		
		for (Class<?> c : handlerClasses) {
			RestHandlerMapping mapping = c.getAnnotation(RestHandlerMapping.class);
			System.out.println("Mappings Availble are :"+mapping.httpMethod());
			System.out.println("Mapping for :"+mapping.path());
						
			try {
				if (!handlerMap.containsKey(mapping.path())) {
					Map <HttpType,RestHandlers> resourceMap = new HashMap<>();
					resourceMap.put(mapping.httpMethod(), (RestHandlers)c.newInstance());
					handlerMap.put(mapping.path(), resourceMap);
				}
				else {
					Map <HttpType,RestHandlers> resourceMap = handlerMap.get(mapping.path());
					resourceMap.put(mapping.httpMethod(), (RestHandlers)c.newInstance());
					handlerMap.put(mapping.path(), resourceMap);
				}
				
				
				
			} catch (InstantiationException | IllegalAccessException e) {
				LOG.error("Error Instantiating Handler: "+ c.getName());
			}
			
		}
		
		 
		
		
	}


	@Override
	public Response handleRequest(Map<String, Object> input, Context context) {

		String httpMethod = (String)input.get("httpMethod");
		String httpBody  = (String)input.get("body");
		String path = (String)input.get("path");
		Map<String,Object> queryParams = (Map)input.get("queryStringParameters");
		
		if (null != queryParams)
		LOG.info("ProductId: "+ (String)queryParams.get("productId"));
		
		LOG.info("received: " + path);
		LOG.info("For : " + httpMethod);
		LOG.info("Request Body: "+ (String)input.get("body"));
		
		return handlerMap.get(path).get(getHttpType(httpMethod)).invoke(httpBody,queryParams);
		
	}
	

	private HttpType getHttpType(String httpMethod) {
		
		HttpType httpType = HttpType.GET;
		switch(httpMethod) {
		case "GET":
			httpType = HttpType.GET;
			break;
		case "POST":
			httpType = HttpType.POST;
			break;
		case "DELETE":
			httpType = HttpType.DELETE;
			break;
		case "PATCH":
			httpType = HttpType.PATCH;
			break;
		default:
			return HttpType.GET;
		}
		return httpType;
	}

	

	public static void main(String[] args) {
		
		
		Test handler = new Test();
		Map<String, Object> input  = new HashMap<>();
		input.put("httpMethod","GET");
		
		Context context = null;
		handler.handleRequest(input, context);
		
		
		
	}
	
static class Test extends FunctionHandler{


		
	}
	
}
