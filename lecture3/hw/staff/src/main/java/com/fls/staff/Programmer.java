package com.fls.staff;

public class Programmer extends Engineer {

    public Programmer() {};

    public Programmer(
        int id,
        String name,
        int worktime,
        int rate,
        int budget,
        String project,
        double contribution,
        int payment
    ) {
        super(id, name, worktime, rate, budget, project, contribution, payment);
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Position: Programmer");
        System.out.println("Worked time: " + worktime + " hours");
        System.out.println("Rate: " + rate + " rubles");
        System.out.println("Project: " + project);
        System.out.println("Contribution to the project: " + contribution);
        System.out.println("Payment: " + payment + " rubles");
    }
}
