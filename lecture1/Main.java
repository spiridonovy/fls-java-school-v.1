public class Main {

    public static void main (String[] args){
        Cat cat = new Cat();
        System.out.println("object cat was created");
        System.out.println("Cat weight - " + cat.getWeight());
        cat.setWeight(3);
        System.out.print("Cat say - ");cat.voice();
        System.out.println("Cat have - " + cat.getCountLives() + " lives=)");
        System.out.println("Cat weight - " + cat.getWeight());

        System.out.println("");

        Dog dog = new Dog();
        System.out.println("object dog was created");
        System.out.println("Dog weight - " + dog.getWeight());
        dog.setWeight(3);
        System.out.print("Dog say - ");dog.voice();
        System.out.println("Dog have - " + dog.getCountLives() + " lives=)");
        System.out.println("Dog weight - " + dog.getWeight());

    }
}
