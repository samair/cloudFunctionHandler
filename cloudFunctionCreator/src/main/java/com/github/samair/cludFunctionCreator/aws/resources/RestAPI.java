package com.github.samair.cludFunctionCreator.aws.resources;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Type", "Properties" })
public class RestAPI implements AWSResource{

	@JsonProperty(value="Type",defaultValue="sad")
	private String type = "AWS::ApiGateway::RestApi";
	@JsonProperty("Properties")
	private Properties properties;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Type")
	public String getType() {
		return type;
	}

	@JsonProperty("Type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("Properties")
	public Properties getProperties() {
		return properties;
	}

	@JsonProperty("Properties")
	public void setProperties(Properties properties) {
		this.properties = properties;
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
