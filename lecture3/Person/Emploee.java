package Person;

import Company.Position;

public class Emploee extends Candidate {
    private Position position;
    private String corporateEmail;

    public Emploee(Candidate candidate, String corpEmail, Position position) {
        super(
                candidate.getName(),
                candidate.getSurname(),
                candidate.getGender(),
                candidate.getBirthDate(),
                candidate.getExpectedPosition(),
                candidate.getEmail()
        );
        this.corporateEmail = corpEmail;
        this.position = position;
    }

    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();
        System.out.println(this.corporateEmail);
        System.out.println(this.position.getDescription());
        System.out.println(this.position.getSalary());
        System.out.println(this.position.getOfficeBuilding().getOfficeName());
        System.out.println(this.position.getRoom().getRoomName());
    }

    @Override
    public void sendMessage(String mesagetext) {
        System.out.println(String.format("Send message to corporate email: %s",mesagetext ));
    }

    public void changeSalary(int salary) {
        this.position.setSalary(salary);
        System.out.println("Salary changed");
    }

    public void changePosition(Position position) {
        this.position = position;
        System.out.println("Position changed");
    }

    public void changeEmail(String email) {
        this.corporateEmail = email;
        System.out.println("Email changed");
    }
    public Candidate fire() {
        this.position=null;
        this.corporateEmail=null;
        System.out.println("Emploee fired");
        return new Candidate(super.getName(),super.getSurname(),super.getGender(),super.getBirthDate(),super.getExpectedPosition(),super.getEmail());
    }

}
