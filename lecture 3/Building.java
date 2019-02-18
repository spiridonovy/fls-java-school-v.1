 abstract class Building {

    private int floors, exits;
    private boolean openRoof;

     public Building(int floors, int exits) {
         this.floors = floors;
         this.exits = exits;
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

    public abstract int EstimateCost();

    public abstract boolean EstimateFireSafety();
}
