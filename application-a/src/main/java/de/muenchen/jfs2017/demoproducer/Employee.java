package de.muenchen.jfs2017.demoproducer;

import lombok.Data;

/**
 *
 * @author claus
 */
@Data
public class Employee {

    public Employee(String surename, String forename, Gender gender, double salary) {
        this.surename = surename;
        this.firstname = forename;
        this.gender = gender;
        this.salary = salary;
    }
    
    private String surename;
    private String firstname;
    private Gender gender;
    private double salary;
    private String position;
    
}
