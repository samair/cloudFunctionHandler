
package com.serverlesshandlers.awsresources;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
public class Resources {

    @JsonIgnore
    private Map<String, AWSResource> additionalProperties = new HashMap<String, AWSResource>();

    @JsonAnyGetter
    public Map<String, AWSResource> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, AWSResource value) {
        this.additionalProperties.put(name, value);
    }

}
