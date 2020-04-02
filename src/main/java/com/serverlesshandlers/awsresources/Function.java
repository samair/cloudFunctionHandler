package com.serverlesshandlers.awsresources;

import java.util.List;

public class Function {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}



	private String handler;
	
	public List<Trigger> getTrigger() {
		return trigger;
	}

	public void setTrigger(List<Trigger> trigger) {
		this.trigger = trigger;
	}



	private List<Trigger> trigger;

}
