package com.datasirpi.dschatbox.repository;

import com.datasirpi.dschatbox.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity,Long> {
}
