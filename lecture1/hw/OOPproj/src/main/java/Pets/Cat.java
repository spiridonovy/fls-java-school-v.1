package Pets;

public class Cat extends Pet {

    public Cat(String name){
        super(name);
    }

    public void voice(){
        System.out.print("Meow ");
        for(int i = 0; i < 20 - this.age; i++){
            System.out.print("meow ");
        }
        System.out.println();
    }
}
