import Pets.Dog;
import Pets.Cat;

public class Main {

    //TODO: Описать любую предметную область в моделях объектно-ориентированного программирования,
    // использую наследование, инкапсуляцию, полиморфизм, абстракцию и композицию по возможности

    public static void main(String[] args) {
        Dog Boby = new Dog("Boby");
        Cat Murka = new Cat("Murka");

        Boby.setAge(13);
        Boby.voice();

        Murka.setAge(1);
        Murka.voice();
    }
}
