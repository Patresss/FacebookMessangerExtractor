package com.patres.messanger.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name="CONVERSATION_ID")
    private Conversation conversation;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "NUMBER_OF_CHARACTERS")
    private int numberOfCharacters;

    @Column(name = "NUMBER_OF_REACTIONS")
    private int numberOfReactions;

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Message setPerson(Person person) {
        this.person = person;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Message setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        this.numberOfCharacters = content == null ? 0 : content.length();
        return this;
    }

    public int getNumberOfCharacters() {
        return numberOfCharacters;
    }

    public Message setNumberOfCharacters(int numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
        return this;
    }

    public int getNumberOfReactions() {
        return numberOfReactions;
    }

    public Message setNumberOfReactions(int numberOfReactions) {
        this.numberOfReactions = numberOfReactions;
        return this;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public Message setConversation(Conversation conversation) {
        this.conversation = conversation;
        return this;
    }
}