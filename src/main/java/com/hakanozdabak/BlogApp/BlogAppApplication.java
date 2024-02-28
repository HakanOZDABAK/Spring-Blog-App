package com.hakanozdabak.BlogApp;

import com.hakanozdabak.BlogApp.business.abstracts.AuthService;
import com.hakanozdabak.BlogApp.business.requests.RegisterRequest;
import com.hakanozdabak.BlogApp.core.utilites.exceptions.BusinessException;
import com.hakanozdabak.BlogApp.core.utilites.exceptions.ProblemDetails;
import com.hakanozdabak.BlogApp.core.utilites.exceptions.ValidationProblemDetails;
import com.hakanozdabak.BlogApp.entities.concretes.Role;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@OpenAPIDefinition
@RestControllerAdvice
@SecurityScheme(
		name = "bearerAuth",
		scheme = "bearer",
		bearerFormat = "JWT",
		type = SecuritySchemeType.HTTP,
		in = SecuritySchemeIn.HEADER
)
public class BlogAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

     @ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails= new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		 return problemDetails;
	 }

	 @ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
		 ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		 validationProblemDetails.setMessage("Validation Exception");
		 validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		 for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
		 validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		 
		 }
		 return validationProblemDetails;
	 }
}


