public class Programmer extends Engineer {
    String language;
    public Programmer(int age, String firstName, String lastName, int income, String language){
        super(age, firstName, lastName, income);
        this.language = language;
    }

    public void getSkill() {
        System.out.println("skill: " + this.language);
        System.out.println();
    }
}