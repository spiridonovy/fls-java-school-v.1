
import MyCollection1.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        MyMap myMap = new MyMap();

        myMap.put("Key1","Value1");
        myMap.put("Key2","Value2");
        myMap.put("Key3",3);
        myMap.put(32,3);

        for (Iterator it = myMap.iterator(); it.hasNext(); ) {
            System.out.println(it.next() );
        }

        System.out.println();

        Map<String,Integer> myMap1 = new HashMap<>();
        myMap1.put("keyfromMap1",5);

        MyMap myMap2 = new MyMap(myMap1);
        for (Iterator it = myMap2.iterator(); it.hasNext(); ) {
            System.out.println(it.next() );
        }
    }
}