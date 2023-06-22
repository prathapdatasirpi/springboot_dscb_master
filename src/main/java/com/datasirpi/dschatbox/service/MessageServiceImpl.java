package com.datasirpi.dschatbox.service;

import com.datasirpi.dschatbox.dto.Message;
import com.datasirpi.dschatbox.entity.MessageEntity;
import com.datasirpi.dschatbox.mapper.MessageMapper;
import com.datasirpi.dschatbox.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(MessageMapper.INSTANCE.messageToMessageEntity(message));
    }

    @Override
    public List<Message> getMessagesById(String senderId, String receiverId) {
        List<MessageEntity> messagesEntities = messageRepository.findAll();
        List<Message> messageList = new ArrayList<>();
        messagesEntities.stream()
                .forEach(messageEntity -> {
                    if((Integer.parseInt(senderId) == messageEntity.getSenderId() && Integer.parseInt(receiverId) == messageEntity.getReceiverId())
                    || ((Integer.parseInt(senderId) == messageEntity.getReceiverId() && Integer.parseInt(receiverId) == messageEntity.getSenderId()))) {
                        messageList.add(mapMessage(messageEntity));
                    }
                });
        return messageList;
    }

    @Override
    public Message mapMessage(MessageEntity messageEntity) {
        Message message = new Message();
        message.setMessageContent(messageEntity.getMessageContent());
        message.setMessageTime(messageEntity.getMessageTime());
        message.setSenderId(messageEntity.getSenderId());
        message.setReceiverId(messageEntity.getReceiverId());
        return message;
    }
}
