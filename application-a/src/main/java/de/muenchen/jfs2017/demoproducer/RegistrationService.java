package de.muenchen.jfs2017.demoproducer;

import lombok.extern.java.Log;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
@Log
public class RegistrationService {
    
    private final ServiceMessaging messaging;

    public RegistrationService(ServiceMessaging messaging) {
        this.messaging = messaging;
    }
    
    public void hireEmployee(Employee employee) {
        this.log.info(String.format("sending employee: \n%s", employee.toString()));
        this.messaging.hireEmployeeEvent().send(MessageBuilder.withPayload(employee).build());
    }
    
}
