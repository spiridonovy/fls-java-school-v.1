package Person;

import java.util.Date;

abstract class Person {
    private String name;
    private String surname;
    private String gender;
    private Date birthDate;

    public Person(String name, String surname, String gender, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public abstract void displayPersonInfo();
}
