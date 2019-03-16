public class test {
    public static void main(String[] args) {
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

        Coleection priceList = new Coleection();
        priceList.addValue(comp1);
        priceList.addValue(comp2);
        priceList.addValue(comp3);

        Computer tempComputer = new Computer();

        tempComputer=priceList.getValue(0);
        System.out.println("Мы Получили: SIZE - "+tempComputer.size+" MODEL - "+tempComputer.model+" PRICE - "+tempComputer.price);
        tempComputer=priceList.getValue(1);
        System.out.println("Мы Получили: SIZE - "+tempComputer.size+" MODEL - "+tempComputer.model+" PRICE - "+tempComputer.price);
        tempComputer=priceList.getValue(2);
        System.out.println("Мы Получили: SIZE - "+tempComputer.size+" MODEL - "+tempComputer.model+" PRICE - "+tempComputer.price);

        priceList.printAll();

        System.out.println("Размер Коллекции = "+priceList.getSize());
    }
}

