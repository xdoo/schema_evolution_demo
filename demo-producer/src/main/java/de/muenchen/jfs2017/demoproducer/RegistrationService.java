package de.muenchen.jfs2017.demoproducer;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
public class RegistrationService {
    
    private final ServiceMessaging messaging;

    public RegistrationService(ServiceMessaging messaging) {
        this.messaging = messaging;
    }
    
    public void hireEmployee(Employee employee) {
        this.messaging.hireEmployeeEvent().send(MessageBuilder.withPayload(employee).build());
    }
    
}
