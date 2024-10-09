package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class permissions {
    @TableId(value="permission_id",type= IdType.AUTO)
    private String permissionId;
    @TableField(value="permission_name")
    private String permissionName;
    private String role;
    private String description;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "permissions{" +
                "permissionId='" + permissionId + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
