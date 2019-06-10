package com.fls.hw3;

public class Designer extends Employee {

    Designer(String varFirstName, String varLastName,
               int varAge, int varWorkExpereince)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
    }

    @Override
    public void doWork()
    {
        System.out.println("Make a design for object");
    }

    @Override
    public void getSalary()
    {
        System.out.println("Get low salary");
        this.setCashAmount(20000);
        System.out.println("New cash amount "+this.getCashAmount());
    }
}
