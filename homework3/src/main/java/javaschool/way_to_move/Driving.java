package javaschool.way_to_move;

public class Driving implements WayToMove {

    public void goLeft(){
        System.out.println ("еду на лево");
    }

    public void goRight(){
        System.out.println("еду на право");
    }

    public void goAhead(){
        System.out.println("еду прямо");
    }

    public void stop(){
        System.out.println("остановился");
    }
}
