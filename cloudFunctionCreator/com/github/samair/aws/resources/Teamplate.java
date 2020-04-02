
package com.github.samair.aws.resources;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AWSTemplateFormatVersion",
    "Description",
    "Resources"
})
public class Teamplate {

    @JsonProperty("AWSTemplateFormatVersion")
    private String aWSTemplateFormatVersion;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Resources")
    private Resources resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AWSTemplateFormatVersion")
    public String getAWSTemplateFormatVersion() {
        return aWSTemplateFormatVersion;
    }

    @JsonProperty("AWSTemplateFormatVersion")
    public void setAWSTemplateFormatVersion(String aWSTemplateFormatVersion) {
        this.aWSTemplateFormatVersion = aWSTemplateFormatVersion;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Resources")
    public Resources getResources() {
        return resources;
    }

    @JsonProperty("Resources")
    public void setResources(Resources resources) {
        this.resources = resources;
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
