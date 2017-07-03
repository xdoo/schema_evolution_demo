package de.muenchen.jfs2017.democonsumer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author claus
 */
@Data
@Builder
@AllArgsConstructor
public class LineItem {
    private String name;
    private int quantity;
    private boolean milk;
    private String size;    
    
}
