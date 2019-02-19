package javaschool.way_to_move;

public class Flying implements WayToMove {

    public void goLeft(){
        System.out.println ("лечу на лево");
    }

    public void goRight(){
        System.out.println ("лечу на право");
    }

    public void goAhead(){
        System.out.println ("лечу прямо");
    }

    public void stop(){
        System.out.println ("посадка");
    }
}
