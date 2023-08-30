package com.patres.messanger.repository;

import com.patres.messanger.entity.Conversation;
import com.patres.messanger.entity.ImportStatus;
import com.patres.messanger.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByTitle(String name);

    @Modifying
    @Query("UPDATE Conversation c set c.importStatus = :importStatus where c.title = :title")
    void markAs(@Param("title") String title, @Param("importStatus") ImportStatus importStatus);

}