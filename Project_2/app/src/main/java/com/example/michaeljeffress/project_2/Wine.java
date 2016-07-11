package com.example.michaeljeffress.project_2;

/**
 * Created by michaeljeffress on 7/10/16.
 */
public class Wine  {
    private int id;
    private String name;
    private String description;
    private Double price;
    private Integer rating;
    private String image;
    private String type;
    private String region;

    public Wine(int id, String name, String description, Double price, Integer rating, String image, String type, String region) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.image = image;
        this.type = type;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getRegion() {
        return region;
    }

    public String getType() {
        return type;
    }

    public Integer getRating() {
        return rating;
    }

    public String getImage() {
        return image;
    }

}
