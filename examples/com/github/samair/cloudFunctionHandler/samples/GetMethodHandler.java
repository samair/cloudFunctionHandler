package com.github.samair.cloudFunctionHandler.samples;

import java.util.Map;

import com.serverlesshandlers.Response;
import com.serverlesshandlers.RestHandlers;
import com.serverlesshandlers.annotations.RestHandlerMapping;
import com.serverlesshandlers.annotations.HttpType;

@RestHandlerMapping(path="/",httpMethod=HttpType.GET)
public class GetMethodHandler implements RestHandlers{

	@Override
	public Response invoke(String httpBody, Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
