import java.util.HashMap;
import java.util.Map;

class Computer{
    public String model;
    public int price;
    public String size;
}
public class Coleection {

    private Map simpleMap = new HashMap();

    public void addValue(Computer someCompucter){
        simpleMap.put(simpleMap.size(), someCompucter);
        System.out.println("Интератор - "+(((int)simpleMap.size())-1));
    }

    public Computer getValue(int key){
        return (Computer)simpleMap.get(key);
    }

    public void printAll(){
        for(int i=0; i<simpleMap.size(); i++){
            System.out.print("SIZE - "+((Computer)simpleMap.get(i)).size);
            System.out.print(" MODEL - "+((Computer)simpleMap.get(i)).model);
            System.out.println(" PRICE - "+((Computer)simpleMap.get(i)).price);
        }
    }

    public int getSize(){
        return simpleMap.size();
    }


}
