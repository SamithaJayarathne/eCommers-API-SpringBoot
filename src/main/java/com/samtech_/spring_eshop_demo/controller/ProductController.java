package com.samtech_.spring_eshop_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/eshop/products")
public class ProductController {

    @GetMapping
    public String firstMethod(){
        return "Hello its get mapping";
    }
}
