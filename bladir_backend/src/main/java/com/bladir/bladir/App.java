package com.bladir.bladir;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bladir.bladir.App;
import com.bladir.database_service.UserServiceImpl;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages={"com.bladir"})
@EnableJpaRepositories("com.bladir")
@EntityScan("com.bladir") 
public class App 
{
	@PostConstruct
	void started() {
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    	System.out.println( "Hello World!" );
    	//userService.createUser();
    	
    }
}