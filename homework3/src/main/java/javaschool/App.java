package javaschool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello Yuri!" );
        DeliveryDrone deliveryDrone = new DeliveryDrone(15, "Delivery", 50);
        DronShip dronShip = new DronShip(1000, "Just Read the Instructions");
        Quadcopter quadcopter = new Quadcopter(10, "Fly");
        VacuumCleanerDrone vacuumCleanerDrone = new VacuumCleanerDrone(30, "Migel");

        deliveryDrone.doWork();
        deliveryDrone.putThePackage();
        deliveryDrone.doWork();

        dronShip.goAhead();
        dronShip.stop();
        dronShip.doWork();

    }
}
