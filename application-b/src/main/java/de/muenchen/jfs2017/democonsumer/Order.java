package de.muenchen.jfs2017.democonsumer;

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
