package com.homework.irina;

public class Three {

    public static void main(String[] args) {
        //название завода
        Factory myfactory = new Factory();
        myfactory.setName("Фрунзе");
        System.out.println("Завод:" + myfactory.getName());
        //численность завода
         myfactory.setPeople(365);
        System.out.println("Численность завода:" + myfactory.getPeople());
        //продукция завода
         myfactory.setProduct("счетчики электроэнергии");
        System.out.println("Производит:" + myfactory.getProduct());
            //цех по производству коруса
        Section onesection = new Section();
        onesection.setDetail("корпус счетчика");
        System.out.println("Цех:" + onesection.getDetail());
        onesection.setHands(65);
        System.out.println("Количество рабочих:" + onesection.getHands());
        onesection.setAccessories("ленточный конвеер, опалубки, ванны для плавки");
        System.out.println("Оборудование:" + onesection.getAccessories());
            //цех по производству платы
        Section twosection = new Section();
        twosection.setDetail("плата счетчика");
        System.out.println("Цех:" + twosection.getDetail());
        twosection.setHands(102);
        System.out.println("Количество рабочих:" + twosection.getHands());
        twosection.setAccessories("два ленточных конвеера, паяльные установки, передвижные лампы");
        System.out.println("Оборудование:" + twosection.getAccessories());

            //цех по производству механизмов вращения
        Section threesection = new Section();
        threesection.setDetail("механизмы вращения");
        System.out.println("Цех:" + threesection.getDetail());
        threesection.setHands(95);
        System.out.println("Количество рабочих:" + threesection.getHands());
        threesection.setAccessories("два ленточных конвеера, паяльные установки, центровочные установки");
        System.out.println("Оборудование:" + threesection.getAccessories());

    }

}
