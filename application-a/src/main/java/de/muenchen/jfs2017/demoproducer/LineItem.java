package de.muenchen.jfs2017.demoproducer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author claus
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItem {
    
    private String name;
    private int quantity;
    private boolean milk;
    private String size;    
    
}
