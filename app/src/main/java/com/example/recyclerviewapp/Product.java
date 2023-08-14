package com.example.recyclerviewapp;

import java.util.List;

public class Product {
    private int id ;
    private String title;
    private String description;
    private int price;
    private List<String> images;

    public Product(int id, String title, String description, int price, List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id'" + id + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
