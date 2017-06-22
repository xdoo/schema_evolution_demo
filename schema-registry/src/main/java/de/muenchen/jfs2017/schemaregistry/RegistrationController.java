package de.muenchen.jfs2017.schemaregistry;

import java.io.IOException;
import java.nio.charset.Charset;
import lombok.extern.java.Log;
import org.apache.commons.io.IOUtils;
import org.springframework.cloud.stream.schema.server.model.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author claus
 */
@RestController
@Log
public class RegistrationController {
    
    @GetMapping("/avroschema/{version}/{name}")
    public Schema avro(
            RestTemplate client, 
            @PathVariable(value = "version") int version,
            @PathVariable(value = "name") String name) throws IOException {
        return this.registerSchema(name, version, client);
    }
    
    public Schema registerSchema(String name, int version, RestTemplate client) throws IOException {
        Schema schema = new Schema();
        schema.setFormat("avro");
        schema.setSubject("de.muenchen.jfs17.Order");
        log.info(String.format("Load Schema v%s from /schema/%s", version, name));
        String jsonSchema = IOUtils.toString(this.getClass().getResourceAsStream("/schema/" + name + ".avsc"), Charset.defaultCharset());
        schema.setDefinition(jsonSchema);
        schema.setVersion(version);
        
        ResponseEntity<Schema> response = client.postForEntity("http://localhost:8990", schema, Schema.class);
        log.info(String.format("registered schema: %s", response.getStatusCode()));
        return response.getBody();
    }

}
