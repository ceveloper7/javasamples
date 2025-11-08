package com.ceva.jpersis.ch02.repositories;

import com.ceva.jpersis.ch02.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
