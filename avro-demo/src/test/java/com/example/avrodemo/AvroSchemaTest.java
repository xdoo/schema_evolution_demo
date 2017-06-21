/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.avrodemo;

import java.io.IOException;
import java.util.List;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author claus
 */
public class AvroSchemaTest {
    
    @Test
    public void testOrderSchemas() throws IOException {
        // version 1.0
        Schema schema01 = new Schema.Parser().parse(this.getClass().getResourceAsStream("/schema/OrderSchema_v1.avsc"));
        assertNotNull(schema01);
        
        // version 2.0
        Schema schema02 = new Schema.Parser().parse(this.getClass().getResourceAsStream("/schema/OrderSchema_v2.avsc"));
        assertNotNull(schema02);
    }
    
}
