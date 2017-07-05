package de.muenchen.jfs2017.demoproducer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author claus
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResource extends ResourceSupport {
    @Singular("lineItem") public List<LineItem> lineItems;
}
