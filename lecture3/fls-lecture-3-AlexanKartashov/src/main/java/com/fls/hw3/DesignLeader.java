package com.fls.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesignLeader extends Employee {

    private int amountOfDesigners;
    private List<Designer> designers;

    DesignLeader(String varFirstName, String varLastName,
               int varAge, int varWorkExpereince)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
        this.designers = new ArrayList<Designer>();
    }

    DesignLeader(String varFirstName, String varLastName,
                 int varAge, int varWorkExpereince,List<Designer> varDesigners)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
        this.designers = varDesigners;
    }

    /*
    * Add new Designer to team of Design Leader
    * */
    public void getNewDesignerToTeam(Designer newDesigner)
    {
        this.designers.add(newDesigner);
    }

    /*
    * Remove designer with specified first and last name from team
     */
    public void firingDesignerFromTeam(String firstName, String lastName)
    {
        for (Iterator<Designer> iter = designers.listIterator(); iter.hasNext(); ) {
            Designer man = iter.next();
            if (man.getFirstName().equals(firstName) && man.getLastName().equals(lastName)) {
                iter.remove();
            }
        }
    }

    @Override
    public void doWork()
    {
        System.out.println("Do some leader job for designing");
        if (designers.size()>0)
        {
            for (Designer designer:
                 designers) {
                System.out.println("Check work of designer "+designer.getFirstName()+
                " "+designer.getLastName());
            }
        }
    }

    @Override
    public void getSalary()
    {
        System.out.println("Get high salary");
        this.setCashAmount(80000);
        System.out.println("New cash amount "+this.getCashAmount());
    }
}
