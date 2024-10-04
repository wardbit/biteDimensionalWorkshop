package com.example.luntan2.entity;

public class tags {
    private int tag_id;
    private String name;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "tags{" +
                "tag_id=" + tag_id +
                ", name='" + name + '\'' +
                '}';
    }
}