package br.com.letscode.eighteleven.samples.cpfValidator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sample api", version = "1.0", description = "Sample API"))
@EnableCaching
public class CPFValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CPFValidatorApplication.class, args);
	}

}
