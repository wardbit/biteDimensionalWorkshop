package com.example.luntan2.entity;

public class post_tags {
    private String post_id;
    private String tag_id;

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    @Override
    public String toString() {
        return "post_tags{" +
                "post_id='" + post_id + '\'' +
                ", tag_id='" + tag_id + '\'' +
                '}';
    }
}
