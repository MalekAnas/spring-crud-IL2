package com.sigma_sw.crud_uppgiften.model.product;


import javax.persistence.*;

@Entity(name = "products")
public class Product {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(nullable = false, unique = true)
    private String productId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int cost;
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


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", category='" + category + '\'' +
                '}';
    }
}
