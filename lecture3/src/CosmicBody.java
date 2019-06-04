public class CosmicBody {
    protected double radius;
    protected int mass;
    protected String name;

    public CosmicBody() {
        radius = 42_000;
        mass = 45_000;
        name = "Uncalled body";
    }

    void flow() {
        System.out.println("This body is flowing in an unlimited space of the Universe.");
    }

    void view() {
        System.out.println("Radius of the body is: " + radius + "km.");
        System.out.println("Current mass: " + mass + " kg.");
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
