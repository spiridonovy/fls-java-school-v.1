package javaschool;

import javaschool.specialization.Unemployed;
import javaschool.way_to_move.Flying;
import javaschool.way_to_move.Unmoved;

public class Quadcopter extends Drone{

    public Quadcopter(int mass, String name){
        super(mass, name);
        super.setWayToMove(new Flying());
    }

}
