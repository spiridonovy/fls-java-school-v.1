public class Engineer extends Employee{
    private int income;

    public Engineer(int age, String firstName, String lastName, int income){
        super(age, firstName, lastName);
        this.income = income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getIncome() {
        System.out.println("income: " + income);
        return income;
    }
    @Override
    public void getInfo() {
        super.getInfo();
        getIncome();
    }

    public void getSkill() {
        System.out.println("skill: math");
        System.out.println();
    }
}