package com.adriel.hexagonalexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootApplication
public class HexagonalExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalExampleApplication.class, args);
	}

}


