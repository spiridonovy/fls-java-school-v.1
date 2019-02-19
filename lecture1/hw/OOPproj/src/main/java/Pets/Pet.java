package Pets;

public class Pet {

    final int maxPetAge = 30;
    public String name;
    public int age;
    public String color;
    public float weight;

    public Pet(String name){
        this.name = name;
    }

    public void setAge(int age) throws Exception{
        if (age < 0 || age > maxPetAge) throw new Exception("Unreal Age of Pet");
        this.age = age;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void voice(){
        System.out.println("I am an animal!");
    }

}