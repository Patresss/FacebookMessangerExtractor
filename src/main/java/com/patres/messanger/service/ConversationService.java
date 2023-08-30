package com.patres.messanger.service;

import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.ImportStatus;
import com.patres.messanger.repository.ConversationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Conversation save(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Conversation saveIfDoesNotExist(Conversation conversation) {
        return conversationRepository.findByTitle(conversation.getTitle())
                .orElseGet(() -> conversationRepository.save(conversation));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void markAsImported(String title) {
        conversationRepository.markAs(title, ImportStatus.IMPORTED);
    }
}
