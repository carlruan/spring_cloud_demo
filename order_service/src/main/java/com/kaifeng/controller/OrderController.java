package com.kaifeng.controller;

import com.kaifeng.model.Product;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    DiscoveryClient discoveryClient;
    //@LoadBalanced
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/buy/{id}")
    public Product findById(@PathVariable Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances("server-item");
        ServiceInstance serviceInstance = instances.get(0);

        String url = "http://server-item/product/" + id;
        Product product = restTemplate.getForObject(url, Product.class);
        return product;

    }
}
