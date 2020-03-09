package com.serverlesshandlers;

import java.util.Map;

public interface RestHandlers {
	
	public Response invoke(String httpBody, Map<String,Object> queryParams);

}
