package com.patres.messanger.mapper;

import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.ImportStatus;
import com.patres.messanger.entity.Person;
import com.patres.messanger.model.ConversationFacebook;
import com.patres.messanger.model.ParticipantFacebook;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends Mapper<Person, ParticipantFacebook> {

    @Override
    public Person toEntity(ParticipantFacebook dto) {
        return new Person()
                .setName(dto.getName());
    }
}
