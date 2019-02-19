package javaschool;

import javaschool.specialization.*;

public class DeliveryDrone extends Quadcopter {
    private int capacity;
    private boolean havePackage;

    public DeliveryDrone(int mass, String name, int capacity){
        super(mass, name);
        this.capacity = capacity;
        havePackage = false;
        this.setSpecialization(new Courier());
    }

    public void takeThePackage(){
        System.out.println("Взял посылку");
        havePackage = true;
    }

    public void putThePackage(){
        System.out.println("Положил посылку");
        havePackage = false;
    }

    @Override
    public void doWork(){
        if(havePackage){
            super.doWork();
        } else{
            System.out.println("Мне нечего доставлять");
        }
    }

}
