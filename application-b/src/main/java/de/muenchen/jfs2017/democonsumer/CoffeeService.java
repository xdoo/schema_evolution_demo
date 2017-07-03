package de.muenchen.jfs2017.democonsumer;

import lombok.extern.java.Log;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
@Log
public class CoffeeService {
    
    @StreamListener(ServiceMessaging.ORDER_COFFEE)
    public void orderCoffe(String order) {
        log.info("Ordered: " + order.toString());
    }
    
}
