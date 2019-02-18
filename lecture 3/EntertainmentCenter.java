public class EntertainmentCenter extends Building {

    private int floors, exits;
    private boolean openRoof;

    private int distanceFromCenter;

    private Cinema cinema = new Cinema(100, 5);

    public EntertainmentCenter(int floors, int exits, int distanceFromCenter) {
        super(floors, exits);
        this.distanceFromCenter = distanceFromCenter;
    }

    public int getLevel() {
        cinema.setCinemaHalls(7);
        return cinema.getLevel();
    }

    private void setFloors(int floors) {
        this.floors = floors;
    }

    private void setExits(int exits) {
        this.exits = exits;
    }

    private void setOpenRoof(boolean openRoof) {
        this.openRoof = openRoof;
    }

    private int getFloors() {
        return floors;
    }

    private int getExits() {
        return exits;
    }

    private boolean getOpenRoof() {
        return openRoof;
    }

    public int getDistanceFromCenter() {
        return distanceFromCenter;
    }

    public void setDistanceFromCenter(int distanceFromCenter) {
        this.distanceFromCenter = distanceFromCenter;
    }

    public boolean isCloseToCenter() {
        if (this.getDistanceFromCenter() < 20) return true;
        else return false;
    }
    @Override
    public int EstimateCost() {
        if (this.getOpenRoof() == true) return 10000;
        else return 5000;
    }

    @Override
    public boolean EstimateFireSafety() {
        if (this.getExits() > getFloors() * 2) return true;
        else return false;
    }
}
