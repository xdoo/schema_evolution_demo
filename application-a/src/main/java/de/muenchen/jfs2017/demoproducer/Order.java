package de.muenchen.jfs2017.demoproducer;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/**
 *
 * @author claus
 */
@Data
@Builder
public class Order {
    @Singular("lineItem") private List<LineItem> lineItem;
}
