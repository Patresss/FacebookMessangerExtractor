package com.patres.messanger.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversationFacebook {
    @JsonProperty("participants")
    private List<ParticipantFacebook> participants = new ArrayList<>();

    @JsonProperty("messages")
    private List<MessageFacebook> messages = new ArrayList<>();

    @JsonProperty("title")
    private String title;


    public List<ParticipantFacebook> getParticipants() {
        return participants;
    }

    public ConversationFacebook setParticipants(List<ParticipantFacebook> participants) {
        this.participants = participants;
        return this;
    }

    public List<MessageFacebook> getMessages() {
        return messages;
    }

    public ConversationFacebook setMessages(List<MessageFacebook> messages) {
        this.messages = messages;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ConversationFacebook setTitle(String title) {
        this.title = title;
        return this;
    }
}