package Pets;

public class Dog extends Pet {

    public Dog(String name){
        super(name);
    }

    public void voice(){
        for(int i = 0; i < 20 - this.age; i++){
            System.out.print("WOOF! ");
        }
        System.out.println();
    }
}
