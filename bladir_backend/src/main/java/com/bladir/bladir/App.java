package com.bladir.bladir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bladir.bladir.App;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages={"com.bladir"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    	System.out.println( "Hello World!" );
    }
}