abstract class Cars {

    private int rudder;
    private String brand;
    private String model;
    protected float fuelLeft;

    public Cars(String carBrand, String carModel) {
        rudder = 1;
        brand  = carBrand;
        model = carModel;
    }

    public abstract void gas();
    public abstract void stop();

    public void statusOfFuelRunningOut(){
        System.out.println("You have " + getFuelLeft() + " liters");
    }

    public void setFuelLeft(float fuel){
        if(fuel < 0)
            System.out.println("Fuel quantity cannot be negative");
        else
            fuelLeft = fuel;
    }

    public float getFuelLeft(){
        return fuelLeft;
    }

}
