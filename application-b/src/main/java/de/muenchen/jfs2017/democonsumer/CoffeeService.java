package de.muenchen.jfs2017.democonsumer;

import java.util.logging.Level;
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
    public void orderCoffe(Order order) {
        log.log(Level.INFO, "Ordered: {0}", order.toString());
    }
    
}
