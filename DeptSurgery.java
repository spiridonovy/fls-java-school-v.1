package com.ClinicProject;

import com.ClinicAbstract.*;
import java.util.List;

public class DeptSurgery extends DeptClinic {
    private int amountEmployees;
    private List<EmployeeClinic> employees;
    private EmployeeClinic departmentHead;
    public DeptSurgery(int amountEmployees, List<EmployeeClinic> employees, EmployeeClinic departmentHead){
        this.amountEmployees = amountEmployees;
        this.employees = employees;
        this.departmentHead = departmentHead;
    }
    public int getAmountEmployees(){
        return amountEmployees;
    }
    public void setAmountEmployees(int amountEmployees){
        this.amountEmployees = amountEmployees;
    }
    public List<EmployeeClinic> getEmployees(){
        return employees;
    }
    public void setEmployees(List<EmployeeClinic> employees){
        this.employees = employees;
    }

    public EmployeeClinic getDepartmentHead() {
        return departmentHead;
    }
    public void setDepartmentHead(EmployeeClinic departmentHead) {
        this.departmentHead = departmentHead;
    }
    @Override
    public void printDepartment(){
        System.out.println("##############################################");
        System.out.println("Surgery Department");
        for (int i = 0; i < amountEmployees - 1; i++){
            System.out.println(employees.get(i));
        }
        System.out.println("Name Surgery department head: " + departmentHead);
    }
}
