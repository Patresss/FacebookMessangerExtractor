package com.patres.messanger.service;

import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.ImportStatus;
import com.patres.messanger.entity.Person;
import com.patres.messanger.repository.ConversationRepository;
import com.patres.messanger.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Person> save(List<Person> people) {
        return personRepository.saveAll(people);
    }

}
