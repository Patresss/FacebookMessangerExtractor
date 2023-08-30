package com.patres.messanger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantFacebook {
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public ParticipantFacebook setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                '}';
    }
}
