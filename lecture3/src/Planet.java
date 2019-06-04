public class Planet extends CosmicBody {
    private boolean hasSatellite;
    private boolean hasLife;
    private Star centralStar;

    public Planet() {
        name = "New Planet";
        hasSatellite = false;
        radius = 542.3;
        mass = 52_000;
        centralStar = new Star("Sun", 695510000.0, false, 1988500000, 38280.0);
    }

    public Planet(String name, double radius, int mass, boolean hasLife, boolean hasSatellite) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.hasLife = hasLife;
        this.hasSatellite = hasSatellite;
    }

    public void bear() {
        System.out.println("Some forms of life appeared.");
        hasLife = true;
    }

    public void die() {
        System.out.println("Everything died on the planet.");
        hasLife = false;
    }

    public void view() {
        System.out.println("Name of the planet: " + name);
        super.view();
        if (hasSatellite)
            System.out.println("This planet has satellite.");
        if (hasLife)
            System.out.println("This planet has life.");
        if (centralStar != null)
            System.out.println("Planet's central star is called: " + centralStar.getName());
    }
    public boolean hasSatellite() {
        return hasSatellite;
    }

    public void setHasSatellite(boolean hasSatellite) {
        this.hasSatellite = hasSatellite;
    }

    public boolean hasLife() {
        return hasLife;
    }

    public Star getCentralStar() {
        return centralStar;
    }

    public void setCentralStar(Star centralStar) {
        this.centralStar = centralStar;
    }
}
