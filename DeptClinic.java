package com.ClinicAbstract;

import java.util.List;

public abstract class DeptClinic {
    private int amountEmployees;
    private List<EmployeeClinic> employees;
    private EmployeeClinic departmentHead;
    public DeptClinic(int amountEmployees, List<EmployeeClinic> employees, EmployeeClinic departmentHead){
        this.amountEmployees = amountEmployees;
        this.employees = employees;
        this.departmentHead = departmentHead;
    }
    public DeptClinic(){

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
    public void printDepartment(){
        System.out.println("Name department");
        for (int i = 0; i < amountEmployees; i++){
            System.out.println(employees.get(i));
        }
        System.out.println("Name department head" + departmentHead);
    }
}
