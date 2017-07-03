package de.muenchen.jfs2017.democonsumer;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author claus
 */
@Data
@NoArgsConstructor
public class Order {
    private List<LineItem> LineItem;
}
