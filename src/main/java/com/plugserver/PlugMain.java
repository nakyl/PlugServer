package com.plugserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PlugMain {

    public static void main(String[] args) {
    	new SpringApplicationBuilder(PlugMain.class)
        .profiles("dev")
        .run(args);
    }
}
