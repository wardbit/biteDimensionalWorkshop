package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class friends {
    @TableId(type= IdType.AUTO,value = "friends_id")
    private int friendsId;
    @TableField(value = "user1_id")
    private int user1Id;
    @TableField(value = "user2_id")
    private int user2Id;
    @TableField(value = "friends_name")
    private String friendsName;


}
