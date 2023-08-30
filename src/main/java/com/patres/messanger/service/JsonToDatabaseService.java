package com.patres.messanger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.Message;
import com.patres.messanger.mapper.ConversationMapper;
import com.patres.messanger.mapper.MessageMapper;
import com.patres.messanger.mapper.PersonMapper;
import com.patres.messanger.model.ConversationFacebook;
import com.patres.messanger.model.MessageFacebook;
import com.patres.messanger.repository.ConversationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JsonToDatabaseService {

    private static final Logger logger = LoggerFactory.getLogger(JsonToDatabaseService.class);


    private final ObjectMapper objectMapper;
    private final ConversationRepository conversationRepository;
    private final ConversationService conversationService;
    private final PersonService personService;
    private final MessageService messageService;
    private final ConversationMapper conversationMapper;
    private final PersonMapper personMapper;
    private final MessageMapper messageMapper;
    @Autowired
    public JsonToDatabaseService(ConversationRepository conversationRepository, ConversationService conversationService, PersonService personService, MessageService messageService, ConversationMapper conversationMapper, PersonMapper personMapper, MessageMapper messageMapper) {
        this.conversationService = conversationService;
        this.personService = personService;
        this.messageService = messageService;
        this.conversationMapper = conversationMapper;
        this.personMapper = personMapper;
        this.messageMapper = messageMapper;
        this.objectMapper = new ObjectMapper();
        this.conversationRepository = conversationRepository;
    }

    @Transactional
    public void loadJsonDataFromInbox(String inboxFolderPath) throws IOException {
        for (File file : getFoldersFromDirectory(inboxFolderPath)) {
            loadJsonData(file.getPath());
        }
    }

    private static List<File> getFoldersFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Provided path is not a valid directory.");
        }

        File[] folderArray = directory.listFiles(File::isDirectory);
        return Arrays.asList(folderArray);
    }

    private void loadJsonData(String folderPath) throws IOException {
        Path directory = Paths.get(folderPath);
        if (!Files.isDirectory(directory)) {
            logger.error("The provided path is not a directory.");
            return;
        }
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory, "*.json")) {
            for (Path path : directoryStream) {
                logger.info("Downloading file: {}", path.getFileName());
                File jsonFile = path.toFile();
                ConversationFacebook conversation = objectMapper.readValue(jsonFile, ConversationFacebook.class);
                loadConversationFacebook(conversation);
            }
        }
    }

    private void loadConversationFacebook(ConversationFacebook conversationFacebook) {
//        logger.info("Adding conversation: {}", conversationFacebook.getTitle());
//        final Conversation conversation = conversationMapper.toEntity(conversationFacebook);
//        final Conversation savedConversation = conversationService.saveIfDoesNotExist(conversation);
//        logger.info("Added conversation: {}", savedConversation.getTitle());

        final String title = conversationFacebook.getTitle();
        logger.info("Adding messages: {}", title);
        final List<MessageFacebook> facebookMessages = conversationFacebook.getMessages().stream()
                .filter(message -> message.getContent() != null)
                .collect(Collectors.toList());
        final List<Message> messages = messageMapper.toEntities(facebookMessages, title);
        final List<Message> saveMessages = messageService.save(messages);
        logger.info("Added {} messages: {}", saveMessages.size(), title);

        conversationService.markAsImported(title);
        logger.info("Imported conversation: {}", title);
    }
}
