package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    public MyFile myFile(){
        return new MyFile();
    }
}
