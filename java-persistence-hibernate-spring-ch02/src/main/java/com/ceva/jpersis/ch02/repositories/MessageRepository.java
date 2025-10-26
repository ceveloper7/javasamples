package com.ceva.jpersis.ch02.repositories;

import com.ceva.jpersis.ch02.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
