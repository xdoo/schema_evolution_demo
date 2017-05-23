package de.muenchen.jfs2017.democonsumer;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
public class BookingService {
    
    private final List<Employee> employees;

    public BookingService() {
        this.employees = Lists.newArrayList();
    }
    
    @StreamListener(ServiceMessaging.HIRE_EMPLOYEE)
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
    
}
