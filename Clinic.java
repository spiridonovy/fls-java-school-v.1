package com.ClinicProject;


public class Clinic {
    EmployeeDepartment empDept;
    DeptSurgery surgery;
    DeptDentistry dentistry;
    DeptOphthalmology ophthalmology;
    DeptDermatology dermatology;
    public Clinic(){
        empDept = new EmployeeDepartment();
        surgery = new DeptSurgery(4,
                empDept.createListEmployees(3), empDept.createEmployee());
        dentistry = new DeptDentistry(7,
                empDept.createListEmployees(6), empDept.createEmployee());
        ophthalmology = new DeptOphthalmology(3,
                empDept.createListEmployees(2), empDept.createEmployee());
        dermatology = new DeptDermatology(5,
                empDept.createListEmployees(4), empDept.createEmployee());
    }
}
