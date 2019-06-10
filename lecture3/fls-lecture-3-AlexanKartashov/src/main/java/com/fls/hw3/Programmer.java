package com.fls.hw3;

public class Programmer extends Employee
{
    Programmer(String varFirstName, String varLastName,
             int varAge, int varWorkExpereince)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
    }

    @Override
    public void doWork()
    {
        System.out.println("Write code in Java as junior");
    }

    @Override
    public void getSalary()
    {
        System.out.println("Get medium salary");
        this.setCashAmount(50000);
        System.out.println("New cash amount "+this.getCashAmount());
    }
}
