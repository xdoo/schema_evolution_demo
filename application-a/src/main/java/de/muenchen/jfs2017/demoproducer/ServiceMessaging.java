package de.muenchen.jfs2017.demoproducer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 *
 * @author claus
 */
public interface ServiceMessaging {
    
    @Output
    MessageChannel orderEvent();
    
}
