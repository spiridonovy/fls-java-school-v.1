package javaschool;

import javaschool.specialization.*;
import javaschool.way_to_move.*;


public abstract class Drone {
    private int mass;
    private String name;

    private Specialization specialization;
    private WayToMove wayToMove;

    public Drone(int mass, String name){
        this.mass = mass;
        this.name = name;
        specialization = new Unemployed();
        wayToMove = new Unmoved();
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setWayToMove(WayToMove wayToMove) {
        this.wayToMove = wayToMove;
    }

    public int getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public void goLeft(){
        wayToMove.goLeft();
    }

    public void goRight(){
        wayToMove.goRight();
    }

    public void goAhead(){
        wayToMove.goAhead();
    }

    public void stop(){
        wayToMove.stop();
    }

    public void doWork(){
        specialization.doYourJobStupidPieceOfIron();
    }
}
