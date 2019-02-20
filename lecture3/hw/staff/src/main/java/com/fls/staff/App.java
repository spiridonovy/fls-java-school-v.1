package com.fls.staff;

public class App {

    public static void main( String[] args ) {
        Programmer p = new Programmer(3, "Petya", 160, 150, 100000, "Homework", 0.3, 0);
        p.calculatePayment();
        p.showInfo();
    }
}
