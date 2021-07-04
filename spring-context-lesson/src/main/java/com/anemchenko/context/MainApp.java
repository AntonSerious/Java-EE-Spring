package com.anemchenko.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        System.out.println("Welcome to the storage! Select products to buy.");
        System.out.println();

        productRepository.showProducts();
        System.out.println();
        System.out.println("Type 'add {id}' to add Product to your Cart");
        System.out.println("Type 'remove {id}' to remove Product from your Cart");
        System.out.println("Type 'show' to display your Cart");
        System.out.println("Type 'finish' to display your Cart");

        Cart cart = applicationContext.getBean(Cart.class);
        String[] commands;
        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            commands = input.split(" ");
            if(commands[0].equals("add")){
                cart.addProduct(Integer.parseInt(commands[1]));
            }
            if(commands[0].equals("remove")){
                cart.removeProductById(Integer.parseInt(commands[1]));
            }
            if(commands[0].equals("show")){
                cart.showCart();
            }
            if(commands[0].equals("finish")){
                System.out.println("You have finished shopping");
                System.out.println();
                cart.showCart();
                break;
            }



        }


        applicationContext.close();
    }
}
