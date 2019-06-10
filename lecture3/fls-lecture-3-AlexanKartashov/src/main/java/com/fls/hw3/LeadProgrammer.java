package com.fls.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeadProgrammer extends Employee {

    private int amountOfProgrammers;
    private List<Programmer> programmers;

    LeadProgrammer(String varFirstName, String varLastName,
                 int varAge, int varWorkExpereince)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
        this.programmers = new ArrayList<Programmer>();
    }

    LeadProgrammer(String varFirstName, String varLastName,
                 int varAge, int varWorkExpereince, List<Programmer> varProgrammers)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
        this.programmers = varProgrammers;
    }

    /*
     * Add new Programmer to team of Design Leader
     * */
    public void getNewDesignerToTeam(Programmer newProgrammer)
    {
        this.programmers.add(newProgrammer);
    }

    /*
     * Remove programmer with specified first and last name from team
     */
    public void firingDesignerFromTeam(String firstName, String lastName)
    {
        for (Iterator<Programmer> iter = programmers.listIterator(); iter.hasNext(); ) {
            Programmer man = iter.next();
            if (man.getFirstName().equals(firstName) && man.getLastName().equals(lastName)) {
                iter.remove();
            }
        }
    }

    @Override
    public void doWork()
    {
        System.out.println("Do some leader job for programming");
        if (programmers.size()>0)
        {
            for (Programmer programmer:
                    programmers) {
                System.out.println("Check work of programmer "+programmer.getFirstName()+
                        " "+programmer.getLastName());
            }
        }
    }

    @Override
    public void getSalary()
    {
        System.out.println("Get very high salary");
        this.setCashAmount(100000);
        System.out.println("New cash amount "+this.getCashAmount());
    }
}
