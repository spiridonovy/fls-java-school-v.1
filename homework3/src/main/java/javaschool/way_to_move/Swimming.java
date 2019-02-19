package javaschool.way_to_move;

public class Swimming implements WayToMove{

    public void goLeft(){
        System.out.println ("плыву на лево");
    }

    public void goRight(){
        System.out.println ("плыву на право");
    }

    public void goAhead(){
        System.out.println ("плыву прямо");
    }

    public void stop(){
        System.out.println ("бросил якорь");
    }
}
