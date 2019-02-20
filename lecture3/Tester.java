public class Tester extends Engineer {
    String test;
    public Tester(int age, String firstName, String lastName, int income, String test){
        super(age, firstName, lastName, income);
        this.test = test;
    }

    public void getSkill() {
        System.out.println("skill: " + this.test);
        System.out.println();
    }
}