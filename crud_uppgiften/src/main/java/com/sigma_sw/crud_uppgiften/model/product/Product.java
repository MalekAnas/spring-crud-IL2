package com.sigma_sw.crud_uppgiften.model.product;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity(name = "products")
public class Product {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(nullable = false, unique = true)
    private String productId;
    @Column(nullable = false)
    @Size(min=3, max = 255, message = "Name length is in range (3-255)")
    private String name;
    @Column(nullable = false)
    @NotNull
    @Positive(message = "Cost must be greater than 0")
    private double cost;
    @Column(nullable = false)
    private String category;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}
