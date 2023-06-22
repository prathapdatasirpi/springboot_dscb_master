package com.datasirpi.dschatbox.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    int messageId;
    String messageContent;
    int senderId;
    int receiverId;
    String messageTime;
}
