package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long furnitureId;
    private String furnitureName;
    private String furnitureColor;
    private String furnitureModel;
    private double price;

    public Furniture() {
    }

    public Furniture(long furnitureId, String furnitureName, String furnitureColor, String furnitureModel, double price) {
        this.furnitureId = furnitureId;
        this.furnitureName = furnitureName;
        this.furnitureColor = furnitureColor;
        this.furnitureModel = furnitureModel;
        this.price = price;
    }

    public long getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(long furnitureId) {
        this.furnitureId = furnitureId;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public String getFurnitureColor() {
        return furnitureColor;
    }

    public void setFurnitureColor(String furnitureColor) {
        this.furnitureColor = furnitureColor;
    }

    public String getFurnitureModel() {
        return furnitureModel;
    }

    public void setFurnitureModel(String furnitureModel) {
        this.furnitureModel = furnitureModel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
