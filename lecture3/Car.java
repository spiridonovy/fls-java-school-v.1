package FLS.lesson3;

public abstract class Car {

    private String model;
    private String color;
    private int maxSpeed;
    private Engine engine;

    public Car() {
        this.engine=new Engine();
        this.model ="";
        this.color = "";
        this.maxSpeed = 0;
    }

    public Car(String model, String color, int maxSpeed , double volume ,double power) {
        engine=new Engine();
        engine.setVolume(volume);
        engine.setPower(power);
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public abstract void drive();

    public abstract void brake();

    public void printInformation() {
        System.out.println("Model : " + model + ", color : " + color +
                ", maximum speed : " + maxSpeed + ", volume of engine : " + engine.getVolume() + ", power of engine : " + engine.getPower());
    }
}
