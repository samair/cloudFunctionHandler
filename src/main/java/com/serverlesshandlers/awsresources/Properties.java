package com.serverlesshandlers.awsresources;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Name", "EndpointConfiguration", "Policy" })
public class Properties {

	@JsonProperty("Name")
	private String name;
	@JsonProperty("EndpointConfiguration")
	private EndpointConfiguration endpointConfiguration;
	@JsonProperty("Policy")
	private String policy;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("EndpointConfiguration")
	public EndpointConfiguration getEndpointConfiguration() {
		return endpointConfiguration;
	}

	@JsonProperty("EndpointConfiguration")
	public void setEndpointConfiguration(EndpointConfiguration endpointConfiguration) {
		this.endpointConfiguration = endpointConfiguration;
	}

	@JsonProperty("Policy")
	public String getPolicy() {
		return policy;
	}

	@JsonProperty("Policy")
	public void setPolicy(String policy) {
		this.policy = policy;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}