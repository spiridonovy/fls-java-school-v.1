package Company;

import Office.OfficeBuilding;
import Office.Room;

public class Position {
    private String description;
    private int salary;
    private OfficeBuilding officeBuilding;
    private Room room;

    public Position(String description, int salary, OfficeBuilding officeBuilding, Room room) {
        this.description = description;
        this.officeBuilding = officeBuilding;
        this.room = room;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public OfficeBuilding getOfficeBuilding() {
        return officeBuilding;
    }

    public String getDescription() {
        return description;
    }

    public Room getRoom() {
        return room;
    }

    public void relocate(OfficeBuilding officeBuilding, Room room) {
        if (this.officeBuilding.getOfficeRooms().contains(room)) {
            this.officeBuilding = officeBuilding;
            this.room = room;
        } else {
            System.out.println("There is no such room in this building!");
        }

        this.officeBuilding = officeBuilding;
    }

}
