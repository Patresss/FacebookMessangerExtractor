package com.patres.messanger.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageFacebook {
    @JsonProperty("sender_name")
    private String senderName;

    @JsonProperty("timestamp_ms")
    private long timestampMs;

    @JsonProperty("content")
    private String content;

    @JsonProperty("reactions")
    private List<ReactionFacebook> reactions = new ArrayList<>();

    public String getSenderName() {
        return senderName;
    }

    public MessageFacebook setSenderName(String senderName) {
        this.senderName = senderName;
        return this;
    }

    public long getTimestampMs() {
        return timestampMs;
    }

    public MessageFacebook setTimestampMs(long timestampMs) {
        this.timestampMs = timestampMs;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MessageFacebook setContent(String content) {
        this.content = content;
        return this;
    }

    public List<ReactionFacebook> getReactions() {
        return reactions;
    }

    public MessageFacebook setReactions(List<ReactionFacebook> reactions) {
        this.reactions = reactions;
        return this;
    }
}
