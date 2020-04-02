package com.serverlesshandlers.awsresources;

public class FunctionSchema {
	
	private String provider;
	
	private String runEnv;
	
	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getRunEnv() {
		return runEnv;
	}

	public void setRunEnv(String runEnv) {
		this.runEnv = runEnv;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	private String payload;
	
	private Function function; 

}
