package com.serverlesshandlers.awsresources;

public class Trigger {
	
	
	@Override
	public String toString() {
		return "Trigger [type=" + type + ", path=" + path + ", method=" + method + "]";
	}

	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	private String path;
	
	private String method;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	

}
