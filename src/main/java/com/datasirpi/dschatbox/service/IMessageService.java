package com.datasirpi.dschatbox.service;

import com.datasirpi.dschatbox.dto.Message;
import com.datasirpi.dschatbox.entity.MessageEntity;

import java.util.List;

public interface IMessageService {
    public void saveMessage(Message message);
    public List<Message> getMessagesById(String senderId, String receiverId);
    public Message mapMessage(MessageEntity messageEntity);
}
