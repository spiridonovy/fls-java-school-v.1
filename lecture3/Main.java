import Person.Candidate;
import Company.Company;
import Company.Position;
import Office.OfficeBuilding;
import Office.Room;
import java.text.*;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /*
     * 1. Сигнатура метода 2. Комментарии 3. Объявление переменных 4. Условные
     * выражения 5. Циклы
     */
    public static void main(String[] args) { // entry point

        var company = new Company("FLS");
        company.addNewOfficeBuilding(new OfficeBuilding(
                "Ulyanova10a",
                new ArrayList<Room>(Arrays.asList(new Room("13"))))
        );
        company.addNewOfficeBuilding(new OfficeBuilding(
                "Ulyanova10b",
                new ArrayList<Room>(Arrays.asList(new Room("10"))))
        );


        var position = new Position(
                "Best job ever",
                1000000,
                company.getOfficeByName("Ulyanova10a"),
                company.getOfficeByName("Ulyanova10a").getOfficeRoomByName("13")
        );


        Candidate newCandidate = null;
        try {
            newCandidate = new Candidate(
                    "Name",
                    "surname",
                    "male",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1994-04-06"),
                    "ExpectedPosition",
                    "email@eamil");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("---------Candidate Info---------");
        newCandidate.displayPersonInfo();
        System.out.println("--------------------------------");

        var newEmploee = newCandidate.hire(position);
        System.out.println("---------New Emploee Info---------");
        newEmploee.displayPersonInfo();
        System.out.println("--------------------------------");


        var second_position = new Position(
                "Best of the best job ever",
                100000000,
                company.getOfficeByName("Ulyanova10b"),
                company.getOfficeByName("Ulyanova10b").getOfficeRoomByName("10")
        );
        newEmploee.changeEmail("newcorpemail@email");
        newEmploee.changePosition(second_position);
        System.out.println("---------New Emploee Info---------");
        newEmploee.displayPersonInfo();
        System.out.println("--------------------------------");

        newEmploee.sendMessage("Hello Emploee!");
        System.out.println("");
        var firedEmploee=newEmploee.fire();
        System.out.println("---------Candidate Info-----------");
        firedEmploee.displayPersonInfo();

    }
}