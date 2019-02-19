package com.fls.hw3;

public abstract class Employee {

    private String firstName;
    private String lastName;

    private int age;
    private int workExperience;
    private int cashAmount;

    /*
    Constructors
     */
    public Employee(String varFirstName, String varLastName,
               int varAge, int varWorkExpereince)
    {
        this.firstName = varFirstName;
        this.lastName = varLastName;
        this.age = varAge;
        this.workExperience = varWorkExpereince;
        this.cashAmount = 0;
    }

    /*
    Abstract methods
     */
    public abstract void doWork();

    public abstract void getSalary();

    /*
    Getters and setters
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }
}
