package com.sigma_sw.crud_uppgiften.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import com.sigma_sw.crud_uppgiften.service.*;
import com.sigma_sw.crud_uppgiften.model.product.*;


@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductRequestModel requestModel) {
        Product savedProduct = productService.addProduct(requestModel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping
    public List<Product> getProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ProductResponseModel getProduct(@PathVariable long id) {
        return productService.getProductById(id);
    }

}
