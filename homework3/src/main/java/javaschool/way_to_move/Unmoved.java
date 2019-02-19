package javaschool.way_to_move;

public class Unmoved implements WayToMove{

    public void goLeft(){
        System.out.println ("не могу двигаться");
    }

    public void goRight(){
        System.out.println ("не могу двигаться");
    }

    public void goAhead(){
        System.out.println ("не могу двигаться");
    }

    public void stop(){
        System.out.println ("все что мне оставется");
    }
}
