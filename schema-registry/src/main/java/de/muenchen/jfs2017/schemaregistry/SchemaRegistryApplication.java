package de.muenchen.jfs2017.schemaregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.server.EnableSchemaRegistryServer;

@SpringBootApplication
@EnableSchemaRegistryServer
public class SchemaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemaRegistryApplication.class, args);
	}
}
