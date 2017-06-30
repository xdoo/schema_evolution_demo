package de.muenchen.jfs2017.demoproducer;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author claus
 */
@Data
@Builder
public class LineItem {
    private String name;
    private int quantity;
    private boolean milk;
    private String size;    
    
}
