package com.patres.messanger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReactionFacebook {
    @JsonProperty("reaction")
    private String reaction;

    @JsonProperty("actor")
    private String actor;

    public String getReaction() {
        return reaction;
    }

    public ReactionFacebook setReaction(String reaction) {
        this.reaction = reaction;
        return this;
    }

    public String getActor() {
        return actor;
    }

    public ReactionFacebook setActor(String actor) {
        this.actor = actor;
        return this;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "reaction='" + reaction + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }
}