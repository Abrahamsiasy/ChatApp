package com.arkham.internfinalchat.Model;

public class User {

    private String id;
    private String username;
    private String imageURL;

    public User(){

    }

    public User(String id, String username, String imageURL) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getImageUrl() {
        return imageURL;
    }

    public void setImageUrl(String image) {
        this.imageURL = image;
    }
}
