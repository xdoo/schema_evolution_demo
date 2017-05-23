package de.muenchen.jfs2017.demoproducer;

/**
 *
 * @author claus
 */
public class Employee {

    public Employee(String surename, String forename, Gender gender, double salary) {
        this.surename = surename;
        this.forename = forename;
        this.gender = gender;
        this.salary = salary;
    }
    
    private String surename;
    private String forename;
    private Gender gender;
    private double salary;
    
}
