package de.muenchen.jfs2017.democonsumer;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author claus
 */
@Data
@NoArgsConstructor
public class LineItem {
    private String name;
    private int quantity;
    private boolean milk;
    private String size;    
    
}
