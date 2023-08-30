package com.patres.messanger.mapper;

import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.ImportStatus;
import com.patres.messanger.entity.Person;
import com.patres.messanger.model.ConversationFacebook;
import com.patres.messanger.model.ParticipantFacebook;
import org.springframework.stereotype.Component;

@Component
public class ConversationMapper extends Mapper<Conversation, ConversationFacebook> {

    @Override
    public Conversation toEntity(ConversationFacebook dto) {
        return new Conversation()
                .setTitle(dto.getTitle())
                .setImportStatus(ImportStatus.NOT_IMPORTED);
    }
}
