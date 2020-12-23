package com.github.sb;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class SbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbApplication.class, args);
	}

	@GetMapping(value = "/", produces = "application/json")
	public String index() {
		log.info("sb request");
		return "<h1>Hello SB!</h1>";
	}

	@GetMapping("t")
	public String testAdvice() {
		log.info("testAdvice");
		return "Test";
	}

}
