package de.muenchen.jfs2017.democonsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.util.MimeType;

@SpringBootApplication
@EnableBinding(ServiceMessaging.class)
@EnableSchemaRegistryClient
public class ApplicationB {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationB.class, args);
    }

    @Bean
    public MessageConverter userMessageConverter() {
        return new AvroSchemaMessageConverter(MimeType.valueOf("application/*+avro"));
    }
}
