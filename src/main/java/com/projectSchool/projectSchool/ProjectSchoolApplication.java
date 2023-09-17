package com.projectSchool.projectSchool;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class ProjectSchoolApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProjectSchoolApplication.class, args);
	}

}
