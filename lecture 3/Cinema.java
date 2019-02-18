public class Cinema {

    private int capacityInOneCinemaHall, cinemaHalls;
    final int HIGH_LEVEL = 100 , MIDDLE_LEVEL = 50, LOW_LEVEL = 10;

    public Cinema(int capacityInOneCinemaHall, int cinemaHalls) {
        this.capacityInOneCinemaHall = capacityInOneCinemaHall;
        this.cinemaHalls = cinemaHalls;
    }
    public int getCinemaHalls() {
        return cinemaHalls;
    }

    public int getCapacityInOneCinemaHall() {
        return capacityInOneCinemaHall;
    }

    public void setCinemaHalls(int cinemaHalls) {
        this.cinemaHalls = cinemaHalls;
    }

    public void setCapacityInOneCinemaHall(int capacity) {
        this.capacityInOneCinemaHall = capacity;
    }

    public int getLevel() {
        int wholeCapacity = this.getCinemaHalls() * this.getCapacityInOneCinemaHall();
        if (wholeCapacity >= 1000) return HIGH_LEVEL;
        else if (wholeCapacity >= 500) return MIDDLE_LEVEL;
        else return LOW_LEVEL;
    }
}
