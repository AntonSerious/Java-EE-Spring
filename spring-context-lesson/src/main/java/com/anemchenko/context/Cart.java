package com.anemchenko.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


@Component
public class Cart {

    @Autowired
    private ProductService productService;

    private ArrayList<Product> cartProductList;

    @PostConstruct
    public void init(){
        cartProductList = new ArrayList<>();
    }

    public void addProduct(int id){
        cartProductList.add(productService.findById(id));
    }

    public void removeProductById(int id){
        cartProductList.removeIf(p -> p.getId() == id);
    }
    public void showCart(){
        System.out.println("Your cart is: ");
        for (Product p: cartProductList
        ) {
            System.out.println(p);
        }
    }

}
