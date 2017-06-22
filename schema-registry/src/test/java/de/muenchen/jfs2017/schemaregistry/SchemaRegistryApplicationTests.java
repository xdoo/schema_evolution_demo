package de.muenchen.jfs2017.schemaregistry;

import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.schema.server.model.Schema;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchemaRegistryApplicationTests {

	@Test
	public void contextLoads() {
	}
        
        @Test
        public void testSchema() throws IOException {
            Schema schema = new Schema();
            schema.setFormat("avro");
            schema.setSubject("de.muenchen.jfs17.Order");
            String jsonSchema = IOUtils.toString(this.getClass().getResourceAsStream("/schema/OrderSchema_v1.avsc"), Charset.defaultCharset());
            schema.setDefinition(jsonSchema);
            System.out.println(schema.getDefinition());
        }

}
