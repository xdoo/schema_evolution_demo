package de.muenchen.jfs2017.schemaregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.stream.schema.server.EnableSchemaRegistryServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableSchemaRegistryServer
public class SchemaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemaRegistryApplication.class, args);
	}
        
        @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
