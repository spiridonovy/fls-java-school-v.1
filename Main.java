package com.homework.irina;

import javax.print.DocFlavor;
import java.beans.Expression;

import static com.homework.irina.MySum.createMySumFromHomeworkType;

public class Main {

    public static void main(String[] args) throws MyWrong {
	// начало
    MyBuffer reader = new MyBuffer ();
        String myFail1 = reader.readToString ("E:/java-homework/calculate.txt");
        System.out.println(reader.readToString(myFail1));
        MySum mySum1 = createMySumFromHomeworkType(myFail1);
        mySum1.printMySum();
       System.out.println("Результат: " + mySum1.calculate());

    }
}
