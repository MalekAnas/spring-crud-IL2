package com.sigma_sw.crud_uppgiften.controller;


import com.sigma_sw.crud_uppgiften.exception.ProductNotFoundException;
import com.sigma_sw.crud_uppgiften.model.product.ProductRequestModel;
import com.sigma_sw.crud_uppgiften.model.product.ProductResponseModel;
import com.sigma_sw.crud_uppgiften.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;



    /*
    * Get all products, returns list of ProductResponseModel
    * */
    @GetMapping
    public List<ProductResponseModel> getProducts() {
        return productService.getAllProducts();
    }


    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductRequestModel requestModel) {
        ProductResponseModel responseModel = productService.addProduct(requestModel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseModel.getProductId()).toUri();
        return ResponseEntity.created(location).build();
    }




    @GetMapping("{id}")
    public ResponseEntity<Object> getProduct(@PathVariable String id) {
        ResponseEntity responseEntity ;
        if (productService.getProductById(id)==null){
             responseEntity = new ResponseEntity<>("Product with ID-"+ id+ " is not found!" , HttpStatus.NOT_FOUND);
            return  responseEntity;
        }
        responseEntity = new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        return responseEntity;
    }


    @PostMapping("{id}")
    public ResponseEntity<Object> updateProduct( @PathVariable String id, @RequestBody ProductRequestModel productRequestModel){


        if (productService.updateProduct(id, productRequestModel)==null) {
            ResponseEntity responseEntity = new ResponseEntity<>(new ProductNotFoundException(
                    "Product with ID-" + id + " is not found!")
                    , HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        ProductResponseModel responseModel= productService.updateProduct(id, productRequestModel);

        ResponseEntity responseEntity = new ResponseEntity<>(responseModel, HttpStatus.ACCEPTED);
        return responseEntity;
    }
}
