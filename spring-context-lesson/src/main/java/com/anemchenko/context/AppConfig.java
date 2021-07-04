package com.anemchenko.context;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.anemchenko.context")
public class AppConfig {
    @Bean
    public MyObject myObject(){
        MyObject mo = new MyObject();
        mo.setValue("ABC");
        return mo;
    }
}
