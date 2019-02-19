public class Star extends CosmicBody {
    private boolean isAlive;
    private double brightness;
    private StarClass clazz;

    private enum StarClass {O, B, A, M, F, G, K}

    public Star() {
        name = "New Star";
        isAlive = true;
        mass = 35_000;
        brightness = 685.3;
        radius = 953.6;
        clazz = StarClass.G;
    }

    public Star(String name, double radius, boolean isAlive, int mass, double brightness) {
        this.name = name;
        this.radius = radius;
        this.isAlive = isAlive;
        this.mass = mass;
        this.brightness = brightness;
    }

    public void die() {
        System.out.println("This star isn't alive any more :(");
        this.isAlive = false;
    }

    public void view() {
        System.out.println("Name of the star: " + name);
        super.view();
        if (isAlive)
            System.out.println("This is the alive star.");
        System.out.println("The brightness: " + brightness + " ");
        if (clazz != null)
            System.out.println("Class of the star: " + clazz.toString());
    }

    public void setClazz(int temperature) {
        if (temperature >= 2000 && temperature < 3500)
            clazz = StarClass.M;
        else if (temperature >=3500 && temperature < 5000)
            clazz = StarClass.K;
        else if (temperature >= 5000 && temperature < 6000)
            clazz = StarClass.G;
        else if (temperature >= 6000 && temperature < 7500)
            clazz = StarClass.F;
        else if (temperature >= 7500 && temperature < 10_000)
            clazz = StarClass.A;
        else if (temperature >= 10_000 && temperature < 30_000)
            clazz = StarClass.B;
        else if (temperature > 30_000 && temperature <= 60_000)
            clazz = StarClass.O;
        else
            System.out.println("Could not identify with any class.");
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getBrightness() {
        return brightness;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }

    public StarClass getClazz() {
        return clazz;
    }
}
