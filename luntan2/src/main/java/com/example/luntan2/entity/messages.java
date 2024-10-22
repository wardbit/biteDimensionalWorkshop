package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class messages {
    @TableId(value="message_id",type= IdType.AUTO)
    private int messageId;
    private String sender;
    @TableField("receiver_id")
    private LocalDateTime receiverId;
    private String content;
    @TableField("sent_at")
    private String sentAt;
    private String image;

}
