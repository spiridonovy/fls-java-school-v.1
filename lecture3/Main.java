public class Main {

    public static void main(String[] args) {
        Engineer[] Engineers = new Engineer[] {
                new Engineer(28, "Makoley", "Kalkin", 50000),
                new Programmer(34, "Joe", "Rogan", 100000, "СOBOL"),
                new Tester(19, "Bob", "Marley", 0, "gtests")};

        for(int i = 0; i < Engineers.length; i++) {
            Engineers[i].getInfo();
            Engineers[i].getSkill();
        }
    }

}
