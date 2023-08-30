package com.patres.messanger.repository;

import com.patres.messanger.entity.Message;
import com.patres.messanger.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}