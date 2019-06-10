package com.fls.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjectDirector extends Employee {

    private List<DesignLeader> designLeaders;
    private List<LeadProgrammer> leadProgrammers;

    ProjectDirector(String varFirstName, String varLastName,
                 int varAge, int varWorkExpereince)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
        this.designLeaders = new ArrayList<DesignLeader>();
        this.leadProgrammers = new ArrayList<LeadProgrammer>();
    }

    ProjectDirector(String varFirstName, String varLastName,
                int varAge, int varWorkExpereince,
                List<DesignLeader> varDesignLeaders,
                List<LeadProgrammer> varLeadProgrammers)
    {
        super(varFirstName,varLastName,varAge,varWorkExpereince);
        this.designLeaders = varDesignLeaders;
        this.leadProgrammers = varLeadProgrammers;
    }

    /*
     * Add new Lead Programmer to team of Project Director
     * */
    public void getNewLeadProgrammerToTeam(LeadProgrammer newLeadProgrammer)
    {
        this.leadProgrammers.add(newLeadProgrammer);
    }

    /*
     * Remove Lead Programmer with specified first and last name from team
     */
    public void firingLeadProgrammerFromTeam(String firstName, String lastName)
    {
        for (Iterator<LeadProgrammer> iter = leadProgrammers.listIterator(); iter.hasNext(); ) {
            LeadProgrammer man = iter.next();
            if (man.getFirstName().equals(firstName) && man.getLastName().equals(lastName)) {
                iter.remove();
            }
        }
    }

    /*
     * Add new Design Leader to team of Project Director
     * */
    public void getNewDesignLeaderToTeam(DesignLeader newDesignLeader)
    {
        this.designLeaders.add(newDesignLeader);
    }

    /*
     * Remove Design Leader with specified first and last name from team
     */
    public void firingDesignLeaderFromTeam(String firstName, String lastName)
    {
        for (Iterator<DesignLeader> iter = designLeaders.listIterator(); iter.hasNext(); ) {
            DesignLeader man = iter.next();
            if (man.getFirstName().equals(firstName) && man.getLastName().equals(lastName)) {
                iter.remove();
            }
        }
    }

    @Override
    public void doWork()
    {
        System.out.println("Do a lot of work");
        if (leadProgrammers.size()>0)
        {
            for (LeadProgrammer leadProgrammer:
                    leadProgrammers) {
                System.out.println("Check work of Lead Programmer "+leadProgrammer.getFirstName()+
                        " "+leadProgrammer.getLastName());
            }
        }

        if (designLeaders.size()>0)
        {
            for (DesignLeader designLeader:
                    designLeaders) {
                System.out.println("Check work of Design Leader "+designLeader.getFirstName()+
                        " "+designLeader.getLastName());
            }
        }
    }

    @Override
    public void getSalary()
    {
        System.out.println("Get very high salary");
        this.setCashAmount(1000000);
        System.out.println("New cash amount "+this.getCashAmount());
    }
}
