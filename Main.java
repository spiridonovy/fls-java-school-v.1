package com.collection;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("*************Test Vector*******************");
        Vector<Integer> myVector = new Vector<>(2);
        for (int i = 0; i < 5; i++) {
            myVector.add(i * i);
        }
        System.out.println("First vector: ");
        for (Iterator<Integer> it = myVector.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println("Element by index: " + myVector.get(2));
        myVector.clear();
        for (int i = 0; i < 9; i++) {
            myVector.add(i + 10);
        }
        for (Iterator<Integer> it = myVector.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        System.out.println("Element by index: " + myVector.get(4));
        myVector.remove(1);
        System.out.println("Vector after deleting element:  ");
        for (Iterator<Integer> it = myVector.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
        myVector.add(2, 9);
        System.out.println("\nVector after adding element:  ");
        for (Iterator<Integer> it = myVector.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }
    }
}
