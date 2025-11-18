package org.function.docker;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudFunctionDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFunctionDockerApplication.class, args);
	}

	@Bean // Bean acts as a endpoint
	Supplier<String> supply() { // method name is endpoint
		return () -> "Hello from Supplier!"; // Supplier just gives output in the datatype mentioned in <>
	}

	@Bean
	Consumer<String> consume() {// i/p string
		return message -> System.out.println("Received: " + message);// Consumer will get i/p and will print in log and
																		// won't return anything(void), only 202
	}

	@Bean
	Function<String, String> upperCaseFunction() {// Gets i/p and gives o/p
		return input -> input.toUpperCase();
	}

	@Bean
	Function<String, String> reverseFunction() {// For function composition demo for chaining functions
		return input -> new StringBuilder(input).reverse().toString();
	}

	@Bean
	Supplier<Integer> supplyInt() {
		return () -> 1234;
	}

	@Bean
	Consumer<Boolean> consumeBoolean() {
		return message -> System.out.println("Received: " + message);
	}

	@Bean
	Function<Integer, String> intPalindromeFunction() {// i/p int and o/p String
		return input -> new StringBuilder(String.valueOf(input)).reverse().toString()
				.equalsIgnoreCase(String.valueOf(input)) ? "Palindrome: " + input : "Not a Palindrome: " + input;
	}

	@Bean
	Function<User, User> writeUser() {
		return input -> input;
	}

}