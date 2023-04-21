package com.example.springmvc;

import com.example.springmvc.models.Recipe;
import com.example.springmvc.models.Userr;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

//@EntityScan(basePackageClasses = {Recipe.class, User.class})
@SpringBootApplication
@EntityScan("com.example.springmvc.models")
public class SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

}
