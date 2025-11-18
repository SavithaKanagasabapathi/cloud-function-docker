package org.function.docker;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class ToLowerCase implements Function<String, String> {// endpoint will be toLowerCase

	@Override
	public String apply(String input) {
		return input.toLowerCase();
	}

}