package com.sigma_sw.crud_uppgiften.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @GetMapping
    public String hello(){
        return "Hello, World";
    }

}
