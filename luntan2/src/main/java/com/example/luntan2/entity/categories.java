package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class categories {
    @TableId(type= IdType.AUTO,value="categories_id")
    private int categoriesId;
    private String name;
    private String description;
    @TableField(value="created_at")
    private LocalDateTime createdAt;
    //描述一个版下全部贴子
    @TableField(exist = false)
    private List<posts> postsList; ;
    @TableField(exist = false)
    private int postsCount; ;


}
