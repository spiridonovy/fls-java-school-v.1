package FLS.lesson6;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        a.add(1); a.add(3);
        a.add(1,6);

        ArrayList<Integer> b=new ArrayList<>();
        b.add(2); b.add(6); b.add(3);
        a.addAll(b);
        a.addAll(0,b);

        Iterator<Integer> it=a.iterator();

        System.out.println("Method check: add(Object), add(index, Object, addAll(Collection), addAll(index. Collection) ");
        System.out.print("ArrayList a: ");

        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

        Iterator<Integer> itB=b.iterator();

        System.out.print("ArrayList b: ");
        while (itB.hasNext()){
            System.out.print(itB.next()+" ");
        }
        System.out.println();

        System.out.println("Method check a.containsAll(b) " +  a.containsAll(b) + " , b.containsAll(a) " +  b.containsAll(a));

        System.out.println("Method check a.contains(10) " + a.contains(10) + " , a.contains(6) "+ a.contains(6));

        System.out.println("Method check a.size() : " + a.size()+"  , b.size() : "+b.size());

        b.clear();
        System.out.println("Method check b.clear() "  + " then b.size(): " +  b.size() + " , check  b.isEmpty() " + b.isEmpty()+ " , check a.isEmpty() "+ a.isEmpty());

        System.out.print("Method check a.toArray() ");
        Object[] array=a.toArray();
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();

        Integer[] tempArr=a.toArray(new Integer[a.size()]);
        System.out.print("Method check a.toArray(new Integer[a.size()]) ");
        for (int i = 0; i <tempArr.length ; i++) {
            System.out.print(tempArr[i]+ " ");
        }
        System.out.println();

        Integer d=1;
        System.out.print("Method check a.remove(Object==1) and a.get(index)");
        a.remove(d);
        for (int i = 0; i < a.size(); i++) {
            System.out.print( a.get(i)+ " ");
        }
        System.out.println();

        a.sort(null);
        System.out.print("Method check a.sort(null) :");
        for (int i = 0; i < a.size(); i++) {
            System.out.print( a.get(i)+ " ");
        }
        a.sort(Collections.reverseOrder());
        System.out.print(" , a.sort(Collections.reverseOrder()) :");
        for (int i = 0; i < a.size(); i++) {
            System.out.print( a.get(i)+ " ");
        }
        System.out.println();

        a.set(0,10);
        a.set(4,20);
        System.out.print("Method check a.set(index,Object)  a.set(0,10) and a.set(4,20) ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print( a.get(i)+ " ");
        }
        System.out.println();

        a.remove(2);
        a.remove(6);
        System.out.print("Method check a.remove(index)  a.remove(2)  and a.remove(6) ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print( a.get(i)+ " ");
        }
        System.out.println();

        System.out.println("Method check a.indexOf(3) "+ a.indexOf(3) + " , a.lastIndexOf(3) "+a.lastIndexOf(3));

        List<Integer> subL=a.subList(1,5);
        System.out.print("Method check  a.subList(1,5) : ");
        for (int i = 0; i <subL.size() ; i++) {
            System.out.print(subL.get(i)+ " ");
        }
        System.out.println();


        b.add(5);b.add(3);b.add(10);
        System.out.print("ArrayList b: ");
        for (int i = 0; i <b.size() ; i++) {
            System.out.print(b.get(i)+" ");
        }
        System.out.println();

        a.retainAll(b);
        System.out.print("Method check  a.retainAll(b) : ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print( a.get(i)+ " ");
        }
        System.out.println();

        b.removeAll(a);
        System.out.print("Method check  b.removeAll(a) : ");
        for (int i = 0; i < b.size(); i++) {
            System.out.print( b.get(i)+ " ");
        }
        System.out.println();

        Iterator<Integer> iter=b.iterator();
        while(iter.hasNext()){
            iter.next();
            iter.remove();
        }
        System.out.println("Method check iterator.next() and iterator.remove(), b.size() " + b.size());

        a.add(6);a.add(30);
        System.out.print("ArrayList a: ");
        for (int i = 0; i <a.size() ; i++) {
            System.out.print(a.get(i)+" ");
        }
        System.out.println();

        ListIterator<Integer> listIt=a.listIterator(1);
        System.out.println("Method check a.listIterator(1) and listIt.next() "+ listIt.next());

        System.out.println("Method check listIt.previous() " + listIt.previous()+ " , listIt.hasPrevious() "+  listIt.hasPrevious() + " ,  listIt.previousIndex() " + listIt.previousIndex());

        System.out.println("Method check listIt.next() "+ listIt.next()+ " , listIt.hasNext() "+ listIt.hasNext()+ " , listIt.nextIndex() "+ listIt.nextIndex());

        listIt.add(5);
        System.out.print("Method check listIt.add(5) : ");
        for (int i = 0; i <a.size() ; i++) {
            System.out.print(a.get(i)+ " ");
        }
        System.out.println();

        listIt.set(3);
        System.out.print("Method check  listIt.set(3) : ");
        for (int i = 0; i <a.size() ; i++) {
            System.out.print(a.get(i)+ " ");
        }

    }
}
