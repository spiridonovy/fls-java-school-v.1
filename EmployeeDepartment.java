package com.ClinicProject;

import com.ClinicAbstract.*;
import java.util.*;

public class EmployeeDepartment{
    private Random rnd = new Random(System.currentTimeMillis());
    public EmployeeClinic createEmployee(){
        String names[] = { "Alex", "John", "Thomas", "Sam", "Bob", "Frank", "El", "Mayson", "Jakson", "Benjamin", "Michael" };
        String surnames[] = {"Smith", "Johnson", "Williams", "Miller", "Parker", "Reed", "Harris", "Walker", "Gray", "Morgan"};
        EmployeeClinic employee = new EmployeeClinic(names[rnd.nextInt(10)], surnames[rnd.nextInt(10)],
                (26 + rnd.nextInt(40)), "position");
        return employee;
    }
    public List<EmployeeClinic> createListEmployees(int amountEmployees){
        List<EmployeeClinic> listEmployees = new ArrayList<EmployeeClinic>();
        for (int i = 0; i < amountEmployees; i++){
            listEmployees.add(createEmployee());
        }
        return listEmployees;
    }
}
