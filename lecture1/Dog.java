public class Dog extends Animal {
    private int weight=1;

    public void voice (){
        System.out.println("GUF");
    }
    public int getWeight(){
        return weight;
    }

    public void setWeight(int mass){
        if(mass>1)weight=mass; else weight=0;
    }

    public int getCountLives(){
        return 1;
    }
}
