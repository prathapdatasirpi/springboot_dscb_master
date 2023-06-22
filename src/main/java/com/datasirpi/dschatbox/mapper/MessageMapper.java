package com.datasirpi.dschatbox.mapper;

import com.datasirpi.dschatbox.dto.Message;
import com.datasirpi.dschatbox.entity.MessageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    // mapping message to messageEntity
    @Mapping(source = "messageId", target = "messageId")
    @Mapping(source = "messageContent", target = "messageContent")
    @Mapping(source = "senderId", target = "senderId")
    @Mapping(source = "receiverId", target = "receiverId")
    @Mapping(source = "messageTime", target = "messageTime")
    MessageEntity messageToMessageEntity(Message message);
}
