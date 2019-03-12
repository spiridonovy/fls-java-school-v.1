import java.util.HashMap;
import java.util.Map;

class Computer{
    public String model;
    public int price;
    public String size;
}
public class Coleection {
    public static void main(String[] args){
        Map simpleMap = new HashMap();
        Computer comp1 = new Computer();
        comp1.model="44";
        comp1.price=100;
        comp1.size="big";
        Computer comp2 = new Computer();
        comp2.model="4481";
        comp2.price=1000;
        comp2.size="midle";
        Computer comp3 = new Computer();
        comp3.model="4500";
        comp3.price=10000;
        comp3.size="small";

        simpleMap.put(comp1.model, comp1);
        simpleMap.put(comp2.model, comp2);
        simpleMap.put(comp3.model, comp3);

        System.out.println("Конкретная модель 44 стоит - "+((Computer) simpleMap.get("44")).price);
        System.out.println("Конкретная модель 44 имеет размер - "+((Computer) simpleMap.get("44")).size);

    }
}
