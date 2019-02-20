public class Employee {
    private int age;
    private String firstName;
    private String lastName;

    public Employee(int age, String firstName, String lastName){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void getInfo() {
        System.out.println("age: " + this.age);
        System.out.println("name:" + this.firstName);
        System.out.println("lastname:" + this.lastName);
    }
}