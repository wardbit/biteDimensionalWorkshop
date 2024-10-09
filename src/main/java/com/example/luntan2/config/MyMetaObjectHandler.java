package com.example.luntan2.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.swagger.annotations.Api;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Api("自动填充器")
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时自动填充
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "lastLogin", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "uploadAt", LocalDateTime.class, LocalDateTime.now());
    }

    // 更新时自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "lastLogin", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateAt", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "uploadAt", LocalDateTime.class, LocalDateTime.now());
    }
}