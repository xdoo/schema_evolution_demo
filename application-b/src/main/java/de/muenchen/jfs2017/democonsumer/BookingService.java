package de.muenchen.jfs2017.democonsumer;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.extern.java.Log;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
@Log
public class BookingService {

    private final List<Employee> employees;

    public BookingService() {
        this.employees = Lists.newArrayList();
    }

    @StreamListener(ServiceMessaging.HIRE_EMPLOYEE)
    public void addEmployee(Employee employee) {
        log.info(String.format("adding employee to my list: \n %s", employee.toString()));
        this.employees.add(employee);
    }

//    @StreamListener(ServiceMessaging.HIRE_EMPLOYEE)
//    public void addEmployee(String msg) {
//        log.info(msg);
//    }

}
