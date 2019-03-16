package com.fls.hw6;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        SingleConnectedLinkedList<Integer> list = new SingleConnectedLinkedList<>();

        list.add(7);
        list.add(3);
        list.add(3);
        list.add(1);

        for (Iterator it = list.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
    }
}
