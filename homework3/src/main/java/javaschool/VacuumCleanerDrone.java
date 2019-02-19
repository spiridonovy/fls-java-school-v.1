package javaschool;

import javaschool.specialization.Cleaner;
import javaschool.way_to_move.Driving;

public class VacuumCleanerDrone extends Drone{

    public VacuumCleanerDrone(int mass, String name){
        super(mass, name);
        this.setSpecialization(new Cleaner());
        this.setWayToMove(new Driving());
    }
}
