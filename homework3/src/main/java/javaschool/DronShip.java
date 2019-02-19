package javaschool;

import javaschool.specialization.*;
import javaschool.way_to_move.*;

public class DronShip extends Drone{

    private boolean haveRocket;
    private Coordinate coordinate;

    public DronShip(int mass, String name){
        super(mass, name);
        coordinate = new Coordinate();
        haveRocket = false;
        this.setSpecialization(new LandingPad());
        this.setWayToMove(new Swimming());
    }

    private class Coordinate{
        public int longitude;
        public int latitude;

        public Coordinate(){
            latitude = 0;
            longitude = 0;
        }

        public void newCoordinate(){
            this.longitude = (int)(Math.random()*(100));
            this.latitude = (int)(Math.random()*(100));
        }
    }

    @Override
    public void goLeft(){
        super.goLeft();
        coordinate.newCoordinate();
    }
    @Override
    public void goRight(){
        super.goRight();
        coordinate.newCoordinate();
    }
    @Override
    public void goAhead(){
        super.goAhead();
        coordinate.newCoordinate();
    }
    @Override
    public void stop(){
        super.stop();
        coordinate.newCoordinate();
    }

    @Override
    public void doWork(){
        if(haveRocket != true){
            super.doWork();
        } else{
            System.out.println("У меня уже есть ракета, вызовите дрона-посыльного");
        }
    }
}
