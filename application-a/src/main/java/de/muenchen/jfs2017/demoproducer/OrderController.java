package de.muenchen.jfs2017.demoproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author claus
 */
@RestController
@Log
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService service;
    
    @GetMapping("/order/random")
    public String placeRandomOrder() {
        return this.service.order(
                Order.builder()
                        .lineItem(LineItem.builder()
                                .name("Kaffee")
                                .quantity(RandomUtils.nextInt(10))
                                .milk(Boolean.TRUE)
                                .size("small").build())
                        .lineItem(LineItem.builder()
                                .name("Kaffee")
                                .quantity(RandomUtils.nextInt(10))
                                .milk(Boolean.FALSE)
                                .size("medium").build())
                        .build()
        );
    }
    
}
