package com.demo.types;


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
        "urlkey",
        "topic_name"
})
public class GroupTopic {

    @JsonProperty("urlkey")
    private String urlkey;
    @JsonProperty("topic_name")
    private String topicName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("urlkey")
    public String getUrlkey() {
        return urlkey;
    }

    @JsonProperty("urlkey")
    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    @JsonProperty("topic_name")
    public String getTopicName() {
        return topicName;
    }

    @JsonProperty("topic_name")
    public void setTopicName(String topicName) {
        this.topicName = topicName;
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