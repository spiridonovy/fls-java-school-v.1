package com.fls.staff;

public abstract class Engineer extends Employee implements IProjectPayment, IWorktimePayment {

    // Плата за час
    protected int rate;

    // Бюджет проекта
    protected int budget;

    protected String project;

    // Вклад в проект
    protected double contribution;

    public Engineer() {
        rate = 0;
        budget = 0;
        project = "";
        contribution = 0;
    }

    public Engineer(
        int id,
        String name,
        int worktime,
        int rate,
        int budget,
        String project,
        double contribution,
        int payment
    ) {
        super(id, name, worktime, payment);
        this.rate = rate;
        this.budget = budget;
        this.project = project;
        this.contribution = contribution;
    }

    @Override
    public void calculatePayment() {
        payment = worktimePayment(worktime, rate) + projectPayment(budget, contribution);
    }

    @Override
    public int projectPayment(int budget, double contribution) {
        return (int)(budget * contribution);
    }

    @Override
    public int worktimePayment(int worktime, int rate) {
        return worktime * rate;
    }
}
