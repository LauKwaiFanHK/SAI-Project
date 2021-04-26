package com.example.demo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Lau Kwai Fan") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping(path = "/hello", consumes = "application/json")
    public void createPerson(@RequestBody String name) {
    	if(!name.equals("Fan")) {
    		System.out.println("Error: Name is not Fan!");
    		throw new WrongNameException();
    	} else {
    		System.out.println(name);
    	}
    }
    
    @ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Wrong name") 
    public class WrongNameException extends RuntimeException {
        
    }
}



