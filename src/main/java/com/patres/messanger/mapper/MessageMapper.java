package com.patres.messanger.mapper;

import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.ImportStatus;
import com.patres.messanger.entity.Message;
import com.patres.messanger.entity.Person;
import com.patres.messanger.model.ConversationFacebook;
import com.patres.messanger.model.MessageFacebook;
import com.patres.messanger.utils.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageMapper {

    public Message toEntity(MessageFacebook dto, String conversationTitle) {
        return new Message()
                .setContent(StringUtils.toUtf(dto.getContent()))
                .setConversation(new Conversation().setTitle(StringUtils.toUtf(conversationTitle)))
                .setCreatedDate(toLocalDateTime(dto.getTimestampMs()))
                .setNumberOfReactions(dto.getReactions().size())
                .setPerson(new Person().setName(StringUtils.toUtf(dto.getSenderName())));
    }

    public List<Message> toEntities(List<MessageFacebook> dtos, String conversationTitle) {
        return dtos.stream()
                .map(dto -> toEntity(dto, conversationTitle))
                .collect(Collectors.toList());
    }

    public LocalDateTime toLocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}
