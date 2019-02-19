package FLS.lesson3;

public class Toyota extends Car{


    public Toyota(String model, String color, int maxSpeed, double volume, double power) {
        super(model, color, maxSpeed, volume, power);
    }

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }

    @Override
    public void brake() {
        System.out.println("Toyota brakes");
    }
}
