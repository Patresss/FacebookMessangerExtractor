package com.patres.messanger.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;


@Entity
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONVERSATION_ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CONVERSATION_ID")
    private List<Message> messages = new ArrayList<>();

    @Column(name = "IMPORT_STATUS")
    @Enumerated(EnumType.STRING)
    private ImportStatus importStatus;

    @Column(name = "TITLE")
    private String title;

    public Long getId() {
        return id;
    }

    public Conversation setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Conversation setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public ImportStatus getImportStatus() {
        return importStatus;
    }

    public Conversation setImportStatus(ImportStatus importStatus) {
        this.importStatus = importStatus;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Conversation setTitle(String title) {
        this.title = title;
        return this;
    }
}
