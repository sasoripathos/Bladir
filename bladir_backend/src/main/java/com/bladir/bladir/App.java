package com.bladir.bladir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bladir.bladir.App;
import com.bladir.database_service.UserService;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages={"com.bladir"})
@EnableJpaRepositories("com.bladir")
@EntityScan("com.bladir") 
public class App 
{
	//@Autowired
	//private static UserService userService;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    	System.out.println( "Hello World!" );
    	//userService.createUser();
    	
    }
}