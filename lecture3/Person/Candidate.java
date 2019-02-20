package Person;

import Company.Position;

import java.util.Date;

public class Candidate extends Person {
    private String expectedPosition;

    public String getExpectedPosition() {
        return expectedPosition;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public Candidate(String name, String surname, String gender, Date birthDate, String expectedPosition, String email) {
        super(name, surname, gender, birthDate);
        this.expectedPosition = expectedPosition;
        this.email = email;
    }

    @Override
    public void displayPersonInfo() {
        System.out.println(this.getName());
        System.out.println(this.getSurname());
        System.out.println(this.getGender());
        System.out.println(this.getBirthDate().toString());
        System.out.println(this.expectedPosition);
        System.out.println(this.email);
    }

    public Emploee hire(Position position) {
        System.out.println("Hire candidate");
        return new Emploee(this, "corp@email", position);
    }

    public void sendMessage(String mesagetext) {
        System.out.println(String.format("Send message to email: %s",mesagetext));
    }


}
