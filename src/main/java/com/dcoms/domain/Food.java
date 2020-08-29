package com.dcoms.domain;

public class Food {

    private String id;
    private String name;
    private Double price;
    private String description;
    private int minuteToPrepare;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinuteToPrepare() {
        return minuteToPrepare;
    }


    public void setMinuteToPrepare(int minuteToPrepare) {
        this.minuteToPrepare = minuteToPrepare;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", minuteToPrepare=" + minuteToPrepare +
                '}';
    }
}
