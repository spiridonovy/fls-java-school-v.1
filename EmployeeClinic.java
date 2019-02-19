package com.ClinicAbstract;

public class EmployeeClinic {
    private String firstName;
    private String lastName;
    private int age;
    private String position;
    public EmployeeClinic(String firstName, String lastName, int age, String position){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age + " " + position;
    }
}
