package com.sigma_sw.crud_uppgiften.model.product;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProductRequestModel {

    @Size(min = 3, message = "Name value should be between 3 and 255 letters")
    private String name;
    @Positive(message = "Cost should be greater than 0")
    private int cost;
    @NotNull
    @Size(min = 3, message = "Category value should be between 3 and 255 letters")
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
