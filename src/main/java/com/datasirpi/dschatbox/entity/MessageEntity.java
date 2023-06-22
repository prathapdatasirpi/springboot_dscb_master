package com.datasirpi.dschatbox.entity;

import com.datasirpi.dschatbox.dto.Message;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "messages")
@Getter
@Setter
public class MessageEntity extends Message implements Serializable {
    @Id
    @Column(name = "message_id")
    private int messageId;

    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "sender_id")
    private int senderId;

    @Column(name = "receiver_id")
    private int receiverId;

    @Column(name = "message_time")
    private String messageTime;
}
