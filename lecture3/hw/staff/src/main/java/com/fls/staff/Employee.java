package com.fls.staff;

public abstract class Employee {

    protected int id;

    protected String name;

    protected int worktime;

    protected int payment;

    public Employee() {
        id = 0;
        name = "";
        worktime = 0;
        payment = 0;
    }

    public Employee(int id, String name, int worktime, int payment) {
        this.id = id;
        this.name = name;
        this.worktime = worktime;
        this.payment = payment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWorktime() {
        return worktime;
    }

    public int getPayment() {
        return payment;
    }

    public abstract void calculatePayment();

    public abstract void showInfo();
}
