package de.muenchen.jfs2017.democonsumer;

import com.google.common.collect.Lists;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
public class BookingService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    private final List<Employee> employees;

    public BookingService() {
        this.employees = Lists.newArrayList();
    }
    
    @StreamListener(ServiceMessaging.HIRE_EMPLOYEE)
    public void addEmployee(Employee employee) {
        log.info(String.format("adding employee %s %s to my list.", employee.getForename(), employee.getSurename()));
        this.employees.add(employee);
    }
    
}
