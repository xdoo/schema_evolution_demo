package de.muenchen.jfs2017.democonsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 *
 * @author claus
 */
public interface ServiceMessaging {
    
    String ORDER_COFFEE = "orderEvent";
    
    @Input(ORDER_COFFEE)
    SubscribableChannel orderEvent();
    
}
