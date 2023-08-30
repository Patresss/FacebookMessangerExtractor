package com.patres.messanger.service;

import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.Message;
import com.patres.messanger.entity.Person;
import com.patres.messanger.repository.ConversationRepository;
import com.patres.messanger.repository.MessageRepository;
import com.patres.messanger.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MessageService {

    private final Map<String, Person> personMap = new ConcurrentHashMap<>();
    private final Map<String, Conversation> conversationMap = new ConcurrentHashMap<>();

    private final MessageRepository messageRepository;
    private final PersonRepository personRepository;
    private final ConversationRepository conversationRepository;

    public MessageService(MessageRepository messageRepository, PersonRepository personRepository, ConversationRepository conversationRepository) {
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
        this.conversationRepository = conversationRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Message> save(List<Message> messages) {
        messages.forEach(this::addPerson);
        messages.forEach(this::addConversation);
        return messageRepository.saveAll(messages);
    }

    private void addPerson(Message message) {
        final String personName = message.getPerson().getName();
        final Person person = personMap.computeIfAbsent(
                personName,
                key -> personRepository.findByName(personName)
                        .orElseGet(() -> personRepository.save(new Person().setName(personName)))
        );
        message.setPerson(person);
    }
    private void addConversation(Message message) {
        final String title = message.getConversation().getTitle();
        final Conversation conversation = conversationMap.computeIfAbsent(
                title,
                key -> conversationRepository.findByTitle(title)
                        .orElseGet(() -> conversationRepository.save(new Conversation().setTitle(title)))
        );
        message.setConversation(conversation);
    }

}
