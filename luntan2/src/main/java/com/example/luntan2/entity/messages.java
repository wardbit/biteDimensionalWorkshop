package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

public class messages {
    @TableId(value="message_id",type= IdType.AUTO)
    private int messageId;
    private String sender;
    @TableField("receiver_id")
    private LocalDateTime receiverId;
    private String content;
    @TableField("sent_at")
    private String sentAt;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(LocalDateTime receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSentAt() {
        return sentAt;
    }

    public void setSentAt(String sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "messages{" +
                "messageId=" + messageId +
                ", sender='" + sender + '\'' +
                ", receiverId=" + receiverId +
                ", content='" + content + '\'' +
                ", sentAt='" + sentAt + '\'' +
                '}';
    }
}
