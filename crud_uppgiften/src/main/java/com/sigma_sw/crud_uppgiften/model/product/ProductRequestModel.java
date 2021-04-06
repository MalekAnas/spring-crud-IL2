package com.sigma_sw.crud_uppgiften.model.product;


public class ProductRequestModel {

    private String name;
    private int cost;
    private String category;

    public ProductRequestModel(String name, int cost, String category ) {
        this.name = name;
        this.cost = cost;
        this.category = category;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
