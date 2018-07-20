package com.example.student.lionmarket.models;

public class GameModel {
    private String imgUrl;
    private String name;
    private String price;
    private String type;
    private String creator;
    private float raiting;
    public boolean isLiked = false;
    public boolean isInBin = false;

    public GameModel(String imgUrl, String name, String price, String type, String creator, int raiting) {
        this.name = name;
        this.price = price + "$";
        this.type = type;
        this.raiting = raiting;
        this.imgUrl = imgUrl;
        this.creator = creator;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getRaiting() {
        return raiting;
    }

    public void setRaiting(float raiting) {
        this.raiting = raiting;
    }

    public GameModel(String creator) {
        this.creator = creator;
    }
}
