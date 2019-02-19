package com.ClinicProject;

public class Main {
    public static void main(String[] args){
        Clinic clinic = new Clinic();

        clinic.surgery.printDepartment();
        clinic.dentistry.printDepartment();
        clinic.ophthalmology.printDepartment();
        clinic.dermatology.printDepartment();
        System.out.println(clinic.dentistry.getAmountEmployees());
    }
}
