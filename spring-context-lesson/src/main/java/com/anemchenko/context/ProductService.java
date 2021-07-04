package com.anemchenko.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(int id)
    {
        return productRepository.findById(id);

    }

    public ProductService() {
    }

}
