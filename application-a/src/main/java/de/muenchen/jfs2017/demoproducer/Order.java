package de.muenchen.jfs2017.demoproducer;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author claus
 */
@Data
@Builder
public class Order {
    private List<LineItem> lineItem;
}
