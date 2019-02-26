public class Cat extends Animal {
    private int weight=0;

    public void voice (){
        System.out.println("Meow");
    }
    public int getWeight(){
        return weight;
    }

    public void setWeight(int mass){
        if(mass>0)weight=mass; else weight=0;
    }

    public int getCountLives(){
        return 9;
    }
}
