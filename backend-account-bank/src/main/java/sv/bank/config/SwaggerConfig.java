package sv.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("Prueba Tecnica PBS")
						.description("Microservicio que Permite la Consulta de Transacciones del Cliente").version("1.0"));
	}
}
