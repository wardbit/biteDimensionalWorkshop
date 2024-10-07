package com.example.luntan2.entity;

public class messages {
    private int message_id;
    private String sender;
    private String receiver_id;
    private String content;
    private String sent_at;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSent_at() {
        return sent_at;
    }

    public void setSent_at(String sent_at) {
        this.sent_at = sent_at;
    }

    @Override
    public String toString() {
        return "message{" +
                "message_id=" + message_id +
                ", sender='" + sender + '\'' +
                ", receiver_id='" + receiver_id + '\'' +
                ", content='" + content + '\'' +
                ", sent_at='" + sent_at + '\'' +
                '}';
    }
}
