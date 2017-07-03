package de.muenchen.jfs2017.demoproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
@Log
@RequiredArgsConstructor
public class OrderService {
    
    private final ServiceMessaging messaging;
    
    public String order(Order order) {
        log.info(String.format("sending order:\n %s", order.toString()));
        boolean result = this.messaging.orderEvent().send(MessageBuilder.withPayload(order).build());
        String msg = (result) ? "Bestellung erfolgreich! " + order.toString() : "Bestellung nicht erfolgreich!";
        return msg;
    }
    
}
