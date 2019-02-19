public class MyCar {
    private PassengerCar pCar;

    public MyCar(String carBrand, String carModel){
        this.pCar = new PassengerCar(carBrand, carModel);
    }

    public void gas(){
        System.out.println("You don't have a driver's license. Stop the car");
    }
}
