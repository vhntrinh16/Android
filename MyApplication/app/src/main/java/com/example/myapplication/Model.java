package com.example.myapplication;

public class Model {
    private String UserId;
    private String Username;
    private String Email;
    private String product_name;
    private String producer;
    private int price;
    private String description;

    public Model(String userId, String username, String email, String product_name, String producer, int price, String description) {
        UserId = userId;
        Username = username;
        Email = email;
        this.product_name = product_name;
        this.producer = producer;
        this.price = price;
        this.description = description;
    }

    public Model() {

    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
