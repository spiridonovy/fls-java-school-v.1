class PassengerCar extends Cars{

    private int wheels;
    private int seats;
    private String carType;

    public PassengerCar(String carBrand, String carModel) {
        super(carBrand, carModel);
        wheels = 4;
        seats = 5;
    }

    public void gas(){
        System.out.println("The car is moving");
    }

    public void stop() {
        System.out.println("The car stopped");
    }

@Override
    public void statusOfFuelRunningOut(){
        //System.out.println("You have " + getFuelLeft() + " liters");
        super.statusOfFuelRunningOut();
        if(fuelLeft <= 10)
            System.out.println("Fuel runs out!");
    }

    public int getWheels(){
        return wheels;
    }

    public int getSeats(){
        return seats;
    }

}
