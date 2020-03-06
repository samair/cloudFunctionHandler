package com.serverlesshandlers;

import java.util.Map;

public interface RestHandlers {
	
	public ApiGatewayResponse invoke(String httpBody, Map<String,Object> queryParams);

}
